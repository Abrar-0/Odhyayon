package com.firstapp.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.*
import com.google.gson.Gson.*
import kotlinx.android.synthetic.main.activity_teacherlogin.*

import com.firstapp.myapplication.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response



class teacherlogin2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teacherlogin)

        teacherloginbtn.setOnClickListener{

            val email1 = email.text.toString().trim()
            val password = editTextTextPassword.text.toString().trim()
            if(email1.isEmpty()){
                email.error ="Email Required"
                email.requestFocus()
                return@setOnClickListener
            }
            if(password.isEmpty()){
                editTextTextPassword.error="Password Required"
                editTextTextPassword.requestFocus()
                return@setOnClickListener
            }
            RetrofitClient.instance.teacher(email1, password)
                .enqueue(object : Callback<teachermodels>{
                    override fun onResponse(
                        call: Call<teachermodels>,
                        response: Response<teachermodels>
                    ) {
                        if (!response.body()?.equals("Unsuccessful")!!)
                        {
                        SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.Email!!)
                         val intent = Intent(applicationContext, teacherdash::class.java)
                         intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                         startActivity(intent)
                        }
                        else {
                            Toast.makeText(
                                applicationContext,
                                "Log in Unsuccessful",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }

                    override fun onFailure(call: Call<teachermodels>, t: Throwable) {
                        Toast.makeText(
                            applicationContext,
                            t.message,
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                })
        }

    }


    override fun onStart() {
        super.onStart()
        if (SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(applicationContext, teacherdash::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)

        }

    }
}



























//        val jsonobject = JSONObject()
//
//
//        val button = findViewById<Button>(R.id.teacherlogin)
//        button.setOnClickListener{
//            val intent = Intent(this, teacherdash::class.java)
//
////            jsonobject.put("Email", email.toString())
////            jsonobject.put("Password", editTextTextPassword.toString())
//
//            val jsonobjectreq = object : StringRequest(Request.Method.GET, url,
//                { response ->
//
//                    Toast.makeText(
//                        applicationContext,
//                        "Response: %s".format(response.toString()),
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                },
//                { error ->
//
//                    Toast.makeText(
//                        applicationContext,
//                        "%s".format(error.toString()),
//                        Toast.LENGTH_SHORT
//                    ).show()
//
//                }
//            )
//
//            {
//                override fun getParams(): MutableMap<String, String> {
//                    val params = HashMap<String,String>()
//                    params.put("Email", email.toString())
//                    params.put("Password", editTextTextPassword.toString())
//                    return params
//                }}
//
//
//            Volley.newRequestQueue(this@teacherlogin2).add(jsonobjectreq)
//            (
//                    DefaultRetryPolicy(
//                        3000,
//                        0,
//                        DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
//                    )
//                    )
//
//        }}}



/* Retrofit retrofit = new Retrofit.Builder()
     .baseUrl(url)
     .addConverterFactory(GsonConverterFactory.create())
     .build()

 myapi api = retrofit . create (myapi.class)

         Call < List < model > > call = api.getmodels();

 call.enqueue(new Callback < List < model > > (){
     onResponse(Call<List<model>> call, Response<List<model>> response) {
         List<model> data = response.body();
         for(int i=0;i<data.size();i++)
             string email= email.gettext

     }
     onFaiure(Call<List<model>> call, Throwable t) {

     }
*/

