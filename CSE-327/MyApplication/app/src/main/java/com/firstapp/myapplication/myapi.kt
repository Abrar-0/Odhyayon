package com.firstapp.myapplication

import retrofit2.http.GET
import com.firstapp.myapplication.teachermodels
import retrofit2.Call

interface myapi {
    @GET("posts")
    fun getmodels(): Call<List<teachermodels?>?>?
}