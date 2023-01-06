package com.firstapp.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_pdfviewer.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.login_button)
        button.setOnClickListener{
            val intent = Intent(this, usercheck_login::class.java)
            startActivity(intent)
        }
        val button1 = findViewById<Button>(R.id.signin_button)
        button1.setOnClickListener{
            val intent = Intent(this, usercheck_signup::class.java)
            startActivity(intent)
        }
        val button2= findViewById<Button>(R.id.example_pdf)
        button2.setOnClickListener{
            val intent2 = Intent(this, PDFViewer::class.java)
            startActivity(intent2)
        }

    }
}
