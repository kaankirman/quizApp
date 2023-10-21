package com.strt.quizapp

object Constants {

    const val  USER_NAME:String="user_name"
    const val TOTAL_QUESTIONS:String="total_questions"
    const val CORRECT_ANSWERS:String="correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        val q1=Question(
            1,"what Country does this flag belong to ?",
            R.drawable.download,
            "Argentina","Australia","Armenia","Austria",1
        )
        questionsList.add(q1)


        val q2=Question(
            2,"what Country does this flag belong to ?",
            R.drawable.australia,
            "Argentina","Australia","Armenia","Austria",2
        )
        questionsList.add(q2)

        val q3=Question(
            3,"what Country does this flag belong to ?",
            R.drawable.fiji,
            "Argentina","Australia","Fiji","Austria",3
        )
        questionsList.add(q3)

        val q4=Question(
            4,"what Country does this flag belong to ?",
            R.drawable.belgium,
            "Argentina","Australia","Armenia","belgium",4
        )
        questionsList.add(q4)

        val q5=Question(
            5,"what Country does this flag belong to ?",
            R.drawable.brazil,
            "Argentina","Brazil","Armenia","Austria",2
        )
        questionsList.add(q5)

        val q6=Question(
            6,"what Country does this flag belong to ?",
            R.drawable.denmark,
            "Denmark","Australia","Armenia","Austria",1
        )
        questionsList.add(q6)

        val q7=Question(
            7,"what Country does this flag belong to ?",
            R.drawable.germany,
            "Argentina","Australia","Germany","Austria",3
        )
        questionsList.add(q7)

        val q8=Question(
            8,"what Country does this flag belong to ?",
            R.drawable.india,
            "Argentina","India","Armenia","Austria",2
        )
        questionsList.add(q8)

        val q9=Question(
            9,"what Country does this flag belong to ?",
            R.drawable.newzelland,
            "Argentina","Australia","Armenia","New Zelland",4
        )
        questionsList.add(q9)

        val q10=Question(
            10,"what Country does this flag belong to ?",
            R.drawable.kuwait,
            "Kuwait","Australia","Armenia","Austria",1
        )
        questionsList.add(q10)

        return questionsList
    }
}