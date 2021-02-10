package io.github.collins993.quizgamekotlin

object Constants {

    const val FINISH: String = "FINISH"
    const val NEXT: String = "NEXT"
    const val SUBMIT: String = "SUBMIT"
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWER: String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{

        val questionList = ArrayList<Question>()

        val question1 = Question(
            1,
            "What is the capital of Chile?",
            "Antofagasta",
            "Santiago",
            "Coquimbo",
            "Columbia",
            2
        )
        questionList.add(question1)

        val question2 = Question(
            2,
            "What is the smallest country in the world?",
            "Uganda",
            "Russia",
            "India",
            "Vatican City",
            4
        )
        questionList.add(question2)

        val question3 = Question(
            3,
            "What is the longest river in the world?",
            "Red",
            "River Nile",
            "Amazon",
            "Mississippi",
            2
        )
        questionList.add(question3)

        val question4 = Question(
            4,
            "What is the hottest continent on Earth?",
            "Africa",
            "Asia",
            "Europe",
            "North-America",
            1
        )
        questionList.add(question4)

        val question5 = Question(
            5,
            "What did the Romans call Scotland?",
            "Caledonia",
            "Macedonian",
            "Greece",
            "Jerusalem",
            1
        )
        questionList.add(question5)

        val question6 = Question(
                6,
                "Which Color is not on the Olympic Rings?",
                "Black",
                "Blue",
                "Yellow",
                "Purple",
                4

        )
        questionList.add(question6)

        val question7 = Question(
                7,
                "How many players are there in a rugby league team?",
                "8",
                "12",
                "13",
                "11",
                3

        )
        questionList.add(question7)

        val question8 = Question(
                8,
                "In bowling, what is the term given for three consecutive strikes?",
                "Trio",
                "A Turkey",
                "A Chicken",
                "Hat-Trick",
                2

        )
        questionList.add(question8)

        val question9 = Question(
                9,
                " Who was Donald Trump's vice president?",
                "Mike Pence",
                "John Kelly",
                "Hilary Clinton",
                "Vladimir Putin",
                1

        )
        questionList.add(question9)

        val question10 = Question(
                10,
                "What is Japanese sake made from?",
                "Grapes",
                "Wheat",
                "Hibiscus Leafs",
                "Rice",
                4

        )
        questionList.add(question10)

        val question11 = Question(
                11,
                "Which vitamin is the only one that you will not find in an egg?",
                "Vitamin B-12",
                "Vitamin C",
                "Vitamin D",
                "Vitamin A",
                2

        )
        questionList.add(question11)

        val question12 = Question(
                12,
                "What is the capital of Westeros in Game of Thrones?",
                "Iron Islands",
                "River run",
                "King's Landing",
                "Casterly Rock",
                3

        )
        questionList.add(question12)

        val question13 = Question(
                13,
                "Which singer was known amongst other things as 'The King of Pop'?",
                "Chris Brown",
                "TimberLake",
                "Usher",
                "Michael Jackson",
                4

        )
        questionList.add(question13)

        val question14 = Question(
                14,
                "Where would you find the River Thames?",
                "London",
                "Italy",
                "South-Korea",
                "Brazil",
                1

        )
        questionList.add(question14)

        val question15 = Question(
                15,
                "The first successful vaccine was introduced by Edward Jenner in 1796. Which disease did it guard against?",
                "Poliomyelitis",
                "Small-Pox",
                "Malaria",
                "Tuberculosis",
                2

        )
        questionList.add(question15)



        return questionList
    }
}