package com.strt.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView




class ResultScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val userName=intent.getStringExtra(Constants.USER_NAME)
        val correctAnswers=intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalQuestion=intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        val nameTv:TextView=findViewById(R.id.nameTv)
        val scoreTv:TextView=findViewById(R.id.scoreTv)
        val endBt:Button=findViewById(R.id.endBt)

        nameTv.text=userName
        scoreTv.text="$correctAnswers Correct Answers out of $totalQuestion"

        endBt.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}