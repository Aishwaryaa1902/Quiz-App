package com.example.quizapp

object Constants
{
 val USER_NAME : String = "UESR_NAME"
 val Correct_Questions : String = "correct"
 val TOTAL_QUESTIONS : String = "total_questions"

    fun getQuestions():ArrayList<Question>
    {
       val questionList = ArrayList<Question>()

        val v1 =Question(1,"What's the name of their latest single?",R.drawable.i1,"Butter","Dynamite",
        "Left and Right","Yet to Come",4)
        questionList.add(v1)

        val v2=Question(2,"How many members does BTS have?" ,
                 R.drawable.i2,"6","7","5","9",2)
        questionList.add(v2)

        val v3 = Question(3,"What does RM stand for?",R.drawable.i5,"Rap Monster","Raplph Morgan","Ron Muldoon","Ronald McDonald",1)

        questionList.add(v3)


        val v4 = Question(4,"When is Suga's birthday?",R.drawable.i3,"Dec 9th","Jan 2nd","March 9th","October 14",3)

        questionList.add(v4)

        val v5 = Question(5,"What was their first single called?",R.drawable.i5,"Kill this Love","Never Give Up","2 kool 4 school","Ready for it",3)

        questionList.add(v5)

        val v6 = Question(6,"What does BTS stand for?",R.drawable.i100,"Behind the Stadium","Bulletproof Boy Scouts","Ron Muldoon","Bantang Soneyodan",4)

        questionList.add(v6)

        val v7 = Question(7,"How did RM learn English?",R.drawable.i7,"By watching friends","Raplph Morgan","Born Too Soon","Netflix",1)

        questionList.add(v7)

        val v8 = Question(8,"What was their first no. 1 hit?",R.drawable.i8,"Life Goes On","Butter","Dynamite","Blood Sweat and Tears",4)

        questionList.add(v8)

        val v9 = Question(9,"What's the name BTS fans give themselves?",R.drawable.i9,"Army","Soldiers","Directioners","Swifties",1)

        questionList.add(v9)

        val v10 = Question(10,"Who's the oldest member?",R.drawable.i100,"Rap Monster","Jin","Suga","Jk",2)

        questionList.add(v10)


        return questionList



    }
}