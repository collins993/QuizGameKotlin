package io.github.collins993.quizgamekotlin

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.widget.TintableCompoundDrawablesView
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import kotlinx.android.synthetic.main.activity_quiz_question.*

class QuizQuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition : Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_question)

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        txt_option_one.setOnClickListener(this)
        txt_option_two.setOnClickListener(this)
        txt_option_three.setOnClickListener(this)
        txt_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)




    }

    private fun setQuestion() {

        val question = mQuestionList!![mCurrentPosition - 1]

        //to unselect all options
        defaultOptionsView()

        //reseting button text
        if (mCurrentPosition == mQuestionList!!.size) {
            btn_submit.text = Constants.FINISH
        }
        else{
            btn_submit.text = Constants.SUBMIT
        }

        //assigning progress bar
        progress_bar.progress = mCurrentPosition
        progress_bar.max = mQuestionList!!.size
        txt_progress.text = "$mCurrentPosition" + "/" + progress_bar.max

        //setting questions
        txt_question_id.text = question.question
        txt_option_one.text = question.optionOne
        txt_option_two.text = question.optionTwo
        txt_option_three.text = question.optionThree
        txt_option_four.text = question.optionFour

        playAnimationOnView(txt_option_one, Techniques.RollIn)
        playAnimationOnView(txt_option_two, Techniques.RollIn)
        playAnimationOnView(txt_option_three, Techniques.RollIn)
        playAnimationOnView(txt_option_four, Techniques.RollIn)
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, txt_option_one)
        options.add(1, txt_option_two)
        options.add(2, txt_option_three)
        options.add(3, txt_option_four)

        for (option in options){
            option.setTextColor(Color.parseColor("#FF000000"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_border
            )
        }
    }

    override fun onClick(view: View?) {

        when(view?.id) {
            R.id.txt_option_one -> {
                selectedOptionsView(txt_option_one, 1)
            }
            R.id.txt_option_two -> {
                selectedOptionsView(txt_option_two, 2)
            }
            R.id.txt_option_three -> {
                selectedOptionsView(txt_option_three, 3)
            }
            R.id.txt_option_four -> {
                selectedOptionsView(txt_option_four, 4)
            }
            R.id.btn_submit ->{
                if (mSelectedOptionPosition == 0) {
                    //moving to the next question
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionList!!.size -> {
                            setQuestion()

                        }
                        else -> {
                           val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }
                else{
                    //checking if answer is correct
                    val question = mQuestionList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)

                    }
                    else{
                        //increase score
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_border)


                    if (mCurrentPosition == mQuestionList!!.size)
                        btn_submit.text = Constants.FINISH
                    else
                        btn_submit.text = Constants.NEXT

                    //reseting selected options view
                    mSelectedOptionPosition = 0



                }
            }
        }
    }

    private fun answerView(answer:Int, drawableView: Int) {
        when(answer) {
            1 -> {
                txt_option_one.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }
            2 -> {
                txt_option_two.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }
            3 -> {
                txt_option_three.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }
            4 -> {
                txt_option_four.background = ContextCompat.getDrawable(
                        this,
                        drawableView
                )
            }
        }
    }

    private fun selectedOptionsView(
            textView: TextView,
            selectedOptionNum: Int
    ) {
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum
        textView.setTextColor(Color.parseColor("#FF000000"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_border
        )
    }

    //playing animation
    private fun playAnimationOnView(view: View?, techniques: Techniques) {

        YoYo.with(Techniques.Tada)
            .duration(700)
            .repeat(0)
            .playOn(view)
    }
}