package com.example.quizapp.constant

import com.example.quizapp.R
import com.example.quizapp.module.Question

object contsrant {

    const val USER_NAME:String ="user_name"
    const val TOTAL_QUESTION:String="total_question"
    const val CURRECT_ANSWERS:String="currect_answers"


    fun getQutions():ArrayList<Question>{
        val questionList = ArrayList<Question>()
        val que1 = Question(
            1,
            "what country does this flag belong to?",
             R.drawable.bangladesh,
            "Argentina",
            "Austriya",
            "Bangladesh",
            "Austria",
            3
        )
        questionList.add(que1)
        val que2 = Question(
            2,
            "what country does this flag belong to?",
            R.drawable.brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )
        questionList.add(que2)
        val que3 = Question(
            3,
            "what country does this flag belong to?",
            R.drawable.china,
            "Belarus",
            "Belize",
            "China",
            "Brazil",
            3
        )
        questionList.add(que3)
        val que4 = Question(
            4,
            "what country does this flag belong to?",
            R.drawable.ghana,
            "Argentina",
            "Gana",
            "Armenia",
            "Austria",
            2
        )
        questionList.add(que4)
        val que5 = Question(
            5,
            "what country does this flag belong to?",
            R.drawable.india,
            "India",
            "Austriya",
            "Armenia",
            "Austria",
            1
        )
        questionList.add(que5)
        val que6 = Question(
            6,
            "what country does this flag belong to?",
            R.drawable.russia,
            "Argentina",
            "Austriya",
            "Armenia",
            "Russia",
            4
        )
        questionList.add(que6)
        val que7 = Question(
            7,
            "what country does this flag belong to?",
            R.drawable.somalia,
            "Argentina",
            "Somalia",
            "Armenia",
            "Austria",
            2
        )
        questionList.add(que7)
        val que8 = Question(
            8,
            "what country does this flag belong to?",
            R.drawable.southafrica,
            "Argentina",
            "Austriya",
            "Armenia",
            "SouthAfrica",
            4
        )
        questionList.add(que8)
        val que9 = Question(
            9,
            "what country does this flag belong to?",
            R.drawable.uk,
            "U.K",
            "Austriya",
            "Armenia",
            "Austria",
            1
        )
        questionList.add(que9)
        val que10 = Question(
            10,
            "what country does this flag belong to?",
            R.drawable.us,
            "Argentina",
            "Austriya",
            "U.S",
            "Austria",
            3
        )
        questionList.add(que10)
        return questionList
    }
}