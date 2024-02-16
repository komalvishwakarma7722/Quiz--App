package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.constant.contsrant
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = intent.getStringExtra(contsrant.USER_NAME)
        binding.tvUser.text=username
        val totalQuestions = intent.getIntExtra(contsrant.TOTAL_QUESTION,0)
        val currectAnswer = intent.getIntExtra(contsrant.CURRECT_ANSWERS,0)

        binding.tvText.text = "Your score is $currectAnswer out of $totalQuestions"

        binding.btnFinish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}