package com.example.retrofitcoroutine

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel :ViewModel(){
    private var repository = Repository()

     fun quote(): MutableLiveData<Resource<QuoteList>>
    {
        return repository.getQuoteRepo()
    }



}





