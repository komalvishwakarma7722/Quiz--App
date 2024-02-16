package com.example.quizapp.module

data class Question(
    val id:Int,
    val quetion:String,
    val image:Int,
    val optionOne:String,
    val optionTwo:String,
    val optionThree:String,
    val optionFour:String,
    val correctAnswer:Int
)
