package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Constants
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.quizapp.constant.contsrant
import com.example.quizapp.databinding.ActivityMainBinding
import com.example.quizapp.databinding.ActivityQuizQuestionBinding
import com.example.quizapp.module.Question

class QuizQuestionActivity : AppCompatActivity(),View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionList:ArrayList<Question>? = null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswers : Int = 0
    private  var mUserName:String? = null

    private lateinit var binding:ActivityQuizQuestionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mUserName = intent.getStringExtra(contsrant.USER_NAME)

        binding= ActivityQuizQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

         mQuestionList = contsrant.getQutions()
        setQuestions()
        binding
        binding.tvOptionOne.setOnClickListener (this)
        binding.tvOptionTwo.setOnClickListener (this)
        binding.tvOptionThree.setOnClickListener (this)
        binding.tvOptionFour.setOnClickListener (this)
        binding.btnSubmit.setOnClickListener (this)
    }
    private fun setQuestions(){
//        mCurrentPosition = 1
        val question = mQuestionList!!.get(mCurrentPosition - 1)

        defaultOptionsView()
        if (mCurrentPosition == mQuestionList!!.size){
            binding.btnSubmit.text = "FINISH"
        }else{
            binding.btnSubmit.text = "SUBMIT"
        }

        binding.progresBar.progress = mCurrentPosition
        binding.tvProgres.text = "$mCurrentPosition" + "/" + binding.progresBar.max

        binding.tvQuestion.text=question!!.quetion
        binding.ivImage.setImageResource(question.image)
        binding.tvOptionOne.text = question.optionOne
        binding.tvOptionTwo.text = question.optionTwo
        binding.tvOptionThree.text = question.optionThree
        binding.tvOptionFour.text = question.optionFour
    }
    private fun defaultOptionsView(){
        val options =ArrayList<TextView>()
        options.add(0,binding.tvOptionOne)
        options.add(1,binding.tvOptionTwo)
        options.add(2,binding.tvOptionThree)
        options.add(3,binding.tvOptionFour)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,
                R.drawable.default_option_border
            )
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_option_one -> {
                selectedOptionView(binding.tvOptionOne, 1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(binding.tvOptionTwo, 2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(binding.tvOptionThree, 3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(binding.tvOptionFour, 4)
            }
            R.id.btn_submit -> {
                if (mSelectedOptionPosition==0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition<=mQuestionList!!.size ->{
                            setQuestions()
                        }else->{
//                        Toast.makeText(this,
//                            "you have succesfullynthe Quize",
//                            Toast.LENGTH_SHORT).show()
                            var intent = Intent(this,ResultActivity::class.java)
                            intent.putExtra(contsrant.USER_NAME,mUserName)
                        intent.putExtra(contsrant.CURRECT_ANSWERS,mCorrectAnswers)
                        intent.putExtra(contsrant.TOTAL_QUESTION,mQuestionList!!.size)
                        startActivity(intent)
                        finish()
                        }
                    }
                }else{
                    val question = mQuestionList?.get(mCurrentPosition-1)
                    if (question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border)
                    if (mCurrentPosition == mQuestionList!!.size){
                        binding.btnSubmit.text = "FINISH"
                    }else{
                        binding.btnSubmit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0
                }
            }
        }

    }

    private fun answerView(answer:Int,drawableview:Int){
        when(answer){
            1 ->{
                binding.tvOptionOne.background = ContextCompat.getDrawable(
                    this,drawableview
                )
            }
            2 ->{
                binding.tvOptionTwo.background = ContextCompat.getDrawable(
                    this,drawableview
                )
            }
            3 ->{
                binding.tvOptionThree.background = ContextCompat.getDrawable(
                    this,drawableview
                )
            }
            4 ->{
                binding.tvOptionFour.background = ContextCompat.getDrawable(
                    this,drawableview
                )
            }
        }
    }
    private fun selectedOptionView(tv: TextView,
                                   selectedOptionNum:Int){
        defaultOptionsView()
         mSelectedOptionPosition=selectedOptionNum
        if (selectedOptionNum == mQuestionList!![mCurrentPosition - 1].correctAnswer) {
            // If the selected option is correct, set the background to green
            tv.setTextColor(Color.parseColor("#2E7D32"))  // Green color
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.correct_option_border)
        } else {
            // If the selected option is incorrect, set the background to red
            tv.setTextColor(Color.parseColor("#D32F2F"))  // Red color
            tv.setTypeface(tv.typeface, Typeface.BOLD)
            tv.background = ContextCompat.getDrawable(this, R.drawable.wrong_option_border)

            // Also, highlight the correct answer by calling answerView
            answerView(mQuestionList!![mCurrentPosition - 1].correctAnswer, R.drawable.correct_option_border)
        }

    }
}