package com.example.retrofitcoroutine

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface QuoteApi {

    @GET("/quotes")
    fun getQuote() : Call<QuoteList>

}