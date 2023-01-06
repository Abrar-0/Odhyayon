package com.firstapp.myapplication

import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import android.os.Bundle
import com.firstapp.myapplication.R
import com.android.volley.toolbox.StringRequest
import android.widget.Toast
import android.content.Intent
import android.view.View
import com.firstapp.myapplication.teacherdash
import com.android.volley.VolleyError
import kotlin.Throws
import com.android.volley.AuthFailureError
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import java.util.HashMap

class MainActivity2 : AppCompatActivity() {
    private var etemail: EditText? = null
    private var etpassword: EditText? = null
    private var Email: String? = null
    private var Password: String? = null
    private val url = "http://127.0.0.1:8000/teacher"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Password = ""
        Email = Password
        etemail = findViewById(R.id.email)
        etpassword = findViewById(R.id.editTextTextPassword)
    }

    fun login(view: View?) {
        Email = etemail!!.text.toString().trim { it <= ' ' }
        Password = etpassword!!.text.toString().trim { it <= ' ' }
        if (Email != "" && Password != "") {
            val stringRequest: StringRequest = object : StringRequest(
                Method.POST,
                url,
                Response.Listener { response ->
                    if (response == "success") {
                        Toast.makeText(
                            this@MainActivity2,
                            String.format(response),
                            Toast.LENGTH_SHORT
                        ).show()
                        val intent = Intent(this@MainActivity2, teacherdash::class.java)
                        startActivity(intent)
                    } else if (response == "failure") {
                        Toast.makeText(
                            this@MainActivity2,
                            String.format(response),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                },
                Response.ErrorListener { error ->
                    Toast.makeText(
                        this@MainActivity2,
                        error.toString().trim { it <= ' ' },
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {
                @Throws(AuthFailureError::class)
                override fun getParams(): Map<String, String>? {
                    val data: MutableMap<String, String> = HashMap()
                    data["Email"] = Email!!
                    data["Password"] = Password!!
                    return data
                }
            }
            val requestQueue = Volley.newRequestQueue(applicationContext)
            requestQueue.add(stringRequest)
        } else {
            Toast.makeText(this, "Fields cannot be empty!", Toast.LENGTH_SHORT).show()
        }
    }
}