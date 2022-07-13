package com.example.kakao_app.Interface

import com.example.kakao_app.DTO.ResultData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Path

interface AuthRetrofitInterface {
    @GET("guestPlace/rank")
    fun GetlLankplace(): Call<ResultData>

    @GET("posts/{page}")
    fun getUserPage(@Path("page") page:String): Call<ResultData>
    abstract fun enqueue(callback: Callback<ResultData>)
}

