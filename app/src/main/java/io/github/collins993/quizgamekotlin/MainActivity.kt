package io.github.collins993.quizgamekotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //remove toolbar
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        /*
        * validate input and send user to quiz screen
        * */
        btn_start.setOnClickListener {

            if (edt_name.text.toString().isEmpty()) {

                Toast.makeText(this, "Please Enter A Name", Toast.LENGTH_SHORT).show()
            } else {

                val intent = Intent(this, QuizQuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, edt_name.text.toString())
                startActivity(intent)
                finish()
            }
        }
    }
}