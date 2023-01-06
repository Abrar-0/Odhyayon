package com.firstapp.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class usercheck_signup : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usercheck_signup)

        val button4: Button = findViewById<Button>(R.id.teacher_signup)
        button4.setOnClickListener{
            val intent = Intent(this, signupteacher::class.java)
            startActivity(intent)
        }
        val button5: Button = findViewById<Button>(R.id.student_signup)
        button5.setOnClickListener{
            val intent = Intent(this, signupStudent::class.java)
            startActivity(intent)
        }
    }
}