package com.firstapp.myapplication

import android.app.ProgressDialog.show
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import com.android.volley.*
import com.android.volley.toolbox.*
import com.google.gson.Gson.*
import kotlinx.android.synthetic.main.activity_teacherlogin.*
import org.json.JSONObject
import com.android.volley.VolleyError
import com.android.volley.toolbox.HurlStack
import retrofit2.Retrofit
import com.android.volley.RetryPolicy
import com.android.volley.DefaultRetryPolicy








class teacherlogin3 : AppCompatActivity() {

    val url = "http://192.168.0.113:8000/teacher"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        val jsonobject = JSONObject()


        val button = findViewById<Button>(R.id.teacherlogin)
        button.setOnClickListener{
            val intent = Intent(this, teacherdash::class.java)

//            jsonobject.put("Email", email.toString())
//            jsonobject.put("Password", editTextTextPassword.toString())

            val jsonobjectreq = object : StringRequest(Request.Method.GET, url,
                { response ->

                    Toast.makeText(
                        applicationContext,
                        "Response: %s".format(response.toString()),
                        Toast.LENGTH_SHORT
                    ).show()

                },
                { error ->

                    Toast.makeText(
                        applicationContext,
                        "%s".format(error.toString()),
                        Toast.LENGTH_SHORT
                    ).show()

                }
            )

            {
                       override fun getParams(): MutableMap<String, String> {
                            val params = HashMap<String,String>()
                            params.put("Email", email.toString())
                            params.put("Password", editTextTextPassword.toString())
                            return params
                        }}


                Volley.newRequestQueue(this@teacherlogin3).add(jsonobjectreq)
            (
                DefaultRetryPolicy(
                    3000,
                    0,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT
                )
            )

        }}}



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

