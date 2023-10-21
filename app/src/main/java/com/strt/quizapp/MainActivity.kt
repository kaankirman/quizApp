package com.strt.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startbtn:Button=findViewById(R.id.startbtn)
        val nameinput:EditText=findViewById(R.id.nameinput)
        startbtn.setOnClickListener(){
            if (nameinput.text.isEmpty())
                Toast.makeText(this,"please enter your name",Toast.LENGTH_LONG).show()
           else{
                val intent = Intent(this,quizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME,nameinput.text.toString())
                startActivity(intent)
                finish()
          }
        }
    }
}