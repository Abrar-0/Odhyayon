package com.firstapp.myapplication

import android.util.Base64
import com.firstapp.myapplication.Retrofitinterface
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

    private val AUTH = "Basic "+ Base64.encodeToString("tanvir@gmail.com:123456".toByteArray(), Base64.NO_WRAP)
    private const val BASE_URL = "http://10.0.2.2:8080"


    private val okHttpClient = OkHttpClient.Builder()

        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .addInterceptor { chain ->
            val original = chain.request()

            val requestBuilder = original.newBuilder()
                .addHeader("Authorization", AUTH)
                .method(original.method, original.body)

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()


    val instance: Retrofitinterface by lazy{
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        retrofit.create(Retrofitinterface::class.java)
    }

}