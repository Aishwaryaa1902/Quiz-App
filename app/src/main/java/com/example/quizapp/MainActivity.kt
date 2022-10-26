package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var etName :TextView=findViewById(R.id.et_Name)
        var btnstart: Button = findViewById(R.id.btn_start)
        btnstart.setOnClickListener {

            if(etName.text.isEmpty())
            {
                Toast.makeText(this,"Enter Your Name",Toast.LENGTH_SHORT).show()
            }
            else
            {
              var intent = Intent(this,QuizQuestions::class.java)
                intent.putExtra(Constants.USER_NAME,etName.text.toString())

                startActivity(intent)
                finish()
            }
        }

    }
}