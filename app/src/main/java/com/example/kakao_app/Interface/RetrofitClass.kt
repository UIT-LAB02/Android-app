package com.example.kakao_app.Interface

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClass {
    val retrofit = Retrofit.Builder()
            .baseUrl("http://oceanit.synology.me:8001/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

}