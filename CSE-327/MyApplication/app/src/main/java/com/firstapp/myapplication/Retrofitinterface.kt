package com.firstapp.myapplication

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface Retrofitinterface {
    @FormUrlEncoded
    @POST("login/")
    fun teacher(
        @Field("username") username: String,
        @Field("password") password: String
    ): Call<teachermodels>
    @POST("signup/")
    fun signup(
        @Field("First_name") First_name:String,
        @Field("Last_name") Last_name:String,
        @Field("Email") Email: String,
        @Field("Phone_number") Phone_number:String,
        @Field("Password") Password: String,
    )
}