package com.strt.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat

class quizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition:Int=1
    private var mQuestionsList:ArrayList<Question>?=null
    private var mSelectedOptionPos: Int=0
    private var mUserName:String?=null
    private var mCorrectAnswers:Int = 0

    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var tvQuestion:TextView?=null
    private var ivImage:ImageView?=null

    private var tvOptionOne:TextView?=null
    private var tvOptionTwo:TextView?=null
    private var tvOptionThree:TextView?=null
    private var tvOptionFour:TextView?=null
    private var submitbt:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        mUserName=intent.getStringExtra(Constants.USER_NAME)

        progressBar=findViewById(R.id.progressbar)
        tvProgress=findViewById(R.id.tv_progress)
        tvQuestion=findViewById(R.id.tv_question)
        ivImage=findViewById(R.id.iv_image)
        tvOptionOne=findViewById(R.id.tv_opt_one)
        tvOptionTwo=findViewById(R.id.tv_opt_two)
        tvOptionThree=findViewById(R.id.tv_opt_three)
        tvOptionFour=findViewById(R.id.tv_opt_four)
        submitbt=findViewById(R.id.submitbt)

        tvOptionOne?.setOnClickListener(this)
        tvOptionTwo?.setOnClickListener(this)
        tvOptionThree?.setOnClickListener(this)
        tvOptionFour?.setOnClickListener(this)
        submitbt?.setOnClickListener(this)

        mQuestionsList = Constants.getQuestions()

        setQuestion()
        defaultOptionsView()

    }

    private fun setQuestion() {
        defaultOptionsView()
        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        ivImage?.setImageResource(question.image)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        tvQuestion?.text = question.question
        tvOptionOne?.text = question.optionOne
        tvOptionTwo?.text = question.optionTwo
        tvOptionThree?.text = question.optionThree
        tvOptionFour?.text = question.optionFour

        if (mCurrentPosition==mQuestionsList!!.size)
            submitbt?.text="Finnish"
        else
            submitbt?.text="Submit"
    }

    private fun  defaultOptionsView (){
        val options = ArrayList<TextView>()
        tvOptionOne?.let {
            options.add(0, it)
        }
        tvOptionTwo?.let {
            options.add(1,it)
        }
        tvOptionThree?.let {
            options.add(2,it)
        }
        tvOptionFour?.let {
            options.add(3,it)
        }
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background= ContextCompat.getDrawable(
                this,R.drawable.questionborder
            )
        }
    }

    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOptionsView()
        mSelectedOptionPos=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_opt_border
        )
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.tv_opt_one -> {tvOptionOne?.let { selectedOptionView(it,1) }}
            R.id.tv_opt_two -> {tvOptionTwo?.let { selectedOptionView(it,2) }}
            R.id.tv_opt_three -> {tvOptionThree?.let { selectedOptionView(it,3) }}
            R.id.tv_opt_four -> {tvOptionFour?.let { selectedOptionView(it,4) }}

            R.id.submitbt->{
                if (mSelectedOptionPos==0) {
                    mCurrentPosition++
                    when{
                        mCurrentPosition<=mQuestionsList!!.size->{setQuestion()}
                        else->{
                            Toast.makeText(this, "You made it to the end", Toast.LENGTH_SHORT).show()
                            val intent = Intent(this,ResultScreen::class.java)
                            intent.putExtra(Constants.USER_NAME,mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList?.size)
                            startActivity(intent)
                        }
                    }
                    
                }else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.coorectAns!=mSelectedOptionPos){
                        answerView(mSelectedOptionPos, R.drawable.wrongopt)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.coorectAns,R.drawable.correctopt)

                    if (mCurrentPosition==mQuestionsList!!.size)
                        submitbt?.text="FINISH"
                    else
                        submitbt?.text="Next"
                    mSelectedOptionPos=0
                }
            }
        }
    }
    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1->{tvOptionOne?.background=ContextCompat.getDrawable(this,drawableView)}
            2->{tvOptionTwo?.background=ContextCompat.getDrawable(this,drawableView)}
            3->{tvOptionThree?.background=ContextCompat.getDrawable(this,drawableView)}
            4->{tvOptionFour?.background=ContextCompat.getDrawable(this,drawableView)}
        }
    }
}