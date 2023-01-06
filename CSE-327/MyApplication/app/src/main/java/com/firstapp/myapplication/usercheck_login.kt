package com.firstapp.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class usercheck_login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usercheck_login)

        val button2: Button = findViewById<Button>(R.id.teacher_login)
        button2.setOnClickListener{
            val intent = Intent(this, teacherdash::class.java)
            startActivity(intent)
        }
        val button3: Button = findViewById<Button>(R.id.student_login)
        button3.setOnClickListener{
            val intent = Intent(this, studentlogin::class.java)
            startActivity(intent)
}}}