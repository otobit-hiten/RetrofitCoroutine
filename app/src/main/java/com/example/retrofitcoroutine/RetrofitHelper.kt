package com.example.retrofitcoroutine

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val BASE_URl = "https://quotable.io/"


    fun getInstance() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URl)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


    val apiService : QuoteApi? = getInstance().create(QuoteApi::class.java)

}