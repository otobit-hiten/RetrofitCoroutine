package com.example.retrofitcoroutine

import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository(){

          fun getQuoteRepo():MutableLiveData<Resource<QuoteList>>
        {
            val mutableLiveData : MutableLiveData<Resource<QuoteList>> = MutableLiveData()
            mutableLiveData.postValue(Resource.loading("loading",null))

            val call: Call<QuoteList>? = RetrofitHelper.apiService?.getQuote()

            call?.enqueue(object : Callback<QuoteList?> {
                override fun onResponse(call: Call<QuoteList?>, response: Response<QuoteList?>) {
                    val responseModel: QuoteList? = response.body()


                    if (responseModel != null) {
                        mutableLiveData.postValue(Resource.success(responseModel))
                    }
                }
                override fun onFailure(call: Call<QuoteList?>, t: Throwable) {
                    mutableLiveData.postValue(Resource.error(t.toString(), null))
                }
            })

            return mutableLiveData
        }























//private val QouteService : QuoteApi
//    private val quoteLiveData = MutableLiveData<QuoteList>()
//    val quote : LiveData<QuoteList>
//        get() = quoteLiveData
//
//    suspend fun getQuoteRepo(page : Int){
//        val res = QouteService.getQuote(page)
//        if (res?.body() != null){
//            quoteLiveData.postValue(res.body())
//        }
//    }
}