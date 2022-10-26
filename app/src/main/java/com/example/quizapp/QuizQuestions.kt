package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import org.w3c.dom.Text
import java.lang.reflect.Array
import java.util.ArrayList

class QuizQuestions : AppCompatActivity() , View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptionPosition: Int = 0

    private var musername: String? = null
    private var progressbar: ProgressBar? = null
    private var tvprogress: TextView? = null
    private var tvquestion: TextView? = null
    private var tvimage: ImageView? = null

    private var tvoption1: TextView? = null
    private var tvoption2: TextView? = null
    private var tvoption3: TextView? = null
    private var tvoption4: TextView? = null
    private var btnSubmit: Button? = null

    private var count: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        progressbar = findViewById(R.id.progressbar)
        tvprogress = findViewById(R.id.tvprogress)
        tvquestion = findViewById(R.id.tvquestion)
        tvimage = findViewById(R.id.tvimage)
        btnSubmit = findViewById((R.id.btnSubmit))

        tvoption1 = findViewById(R.id.option1)
        tvoption2 = findViewById(R.id.option2)
        tvoption3 = findViewById(R.id.option3)
        tvoption4 = findViewById(R.id.option4)

        musername = intent.getStringExtra(Constants.USER_NAME)



        mQuestionList = Constants.getQuestions()






        setQuestion()


    }

    private fun setQuestion()
    {

        defaultOptionView()
        val question: Question = mQuestionList!![mCurrentPosition-1]
        progressbar?.progress = mCurrentPosition + 1
        tvimage?.setImageResource(question.image)
        tvprogress?.text = "${mCurrentPosition + 1}/${progressbar?.max}"
        tvquestion?.text = question.question
        tvoption1?.text = question.option1
        tvoption2?.text = question.option2
        tvoption3?.text = question.option3
        tvoption4?.text = question.option4

        tvoption1?.setOnClickListener(this)
        tvoption2?.setOnClickListener(this)
        tvoption3?.setOnClickListener(this)
        tvoption4?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)



        if (mCurrentPosition == mQuestionList!!.size)
        {
            btnSubmit?.text = "FINISH"
        } else
        {
            btnSubmit?.text = "SUBMIT"
        }
    }

    private fun selectedOptionView(tv: TextView, selectedOptionNum: Int)
    {
        defaultOptionView()
        mSelectedOptionPosition = selectedOptionNum
        tv.setTextColor(Color.parseColor("#3A3A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this, R.drawable.selected_option
        )

    }

    private fun defaultOptionView() {
        val options = ArrayList<TextView>()
        tvoption1?.let {
            options.add(0, it)
        }
        tvoption2?.let {
            options.add(1, it)
        }
        tvoption3?.let {
            options.add(2, it)
        }
        tvoption4?.let {
            options.add(3, it)
        }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                this, R.drawable.defalut_option_bg
            )
        }
    }

    override fun onClick(view: View?)
    {
        when (view?.id)
        {
            R.id.option1 -> {
                tvoption1?.let {
                    selectedOptionView(it, 1)
                }
            }

            R.id.option2 -> {
                tvoption2?.let {
                    selectedOptionView(it, 2)
                }
            }
            R.id.option3 -> {
                tvoption3?.let {
                    selectedOptionView(it, 3)
                }
            }
            R.id.option4 -> {
                tvoption4?.let {
                    selectedOptionView(it, 4)
                }
            }

            R.id.btnSubmit ->
            {
                if (mSelectedOptionPosition == 0)
                {
                    mCurrentPosition++


                    when
                    {
                        mCurrentPosition <= mQuestionList!!.size->
                        {
                            setQuestion()
                        }

                        else->
                        {

                            var intent = Intent(this, ResultScreen::class.java)
                            intent.putExtra(Constants.USER_NAME, musername)
                            intent.putExtra(Constants.Correct_Questions, count,)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList?.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }
                else
                 {
                    val question = mQuestionList?.get(mCurrentPosition - 1)

                    if (question!!.correctAnswer!= mSelectedOptionPosition)
                    {
                        answerView(mSelectedOptionPosition, R.drawable.wrong_option_border)
                    } else
                    {
                        count++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_bg)

                    if (mCurrentPosition == mQuestionList!!.size)
                    {
                        btnSubmit?.text = "Finish"
                    } else
                    {
                        btnSubmit?.text = "Go to next question"
                    }
                    mSelectedOptionPosition = 0

                }



            }
        }
    }


    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                tvoption1?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                tvoption2?.background = ContextCompat.getDrawable(
                    this, drawableView
                )

            }
            3 -> {
                tvoption3?.background = ContextCompat.getDrawable(
                    this, drawableView
                )

            }
            4 -> {
                tvoption4?.background = ContextCompat.getDrawable(
                    this, drawableView
                )

            }

        }
    }
}

