package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultScreen : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_screen)

        var us :TextView= findViewById(R.id.tv_name)
        var tq :TextView= findViewById(R.id.tv_score)
        var btnFinish :Button= findViewById(R.id.btnFinish)

        us.text = intent.getStringExtra(Constants.USER_NAME)
        val totalq =intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val correctq =intent.getIntExtra(Constants.Correct_Questions,0)

        tq.text = "Your Score is ${correctq} / ${totalq}"


        btnFinish.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }




    }
}