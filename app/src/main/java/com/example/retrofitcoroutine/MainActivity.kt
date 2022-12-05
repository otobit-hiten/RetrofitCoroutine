package com.example.retrofitcoroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
//    private var _id: String = ""
//    private var author: String = ""
//    private var authorSlug: String = ""
//    private var content: String = ""
//    private var dateAdded: String = ""
//    private var dateModified: String = ""



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider.AndroidViewModelFactory.getInstance(application).create(MainViewModel::class.java)
        Quote()
    }

    private fun Quote() {
        viewModel.quote().observe(this, Observer {
            when(it.status){
                Status.SUCCESS -> {
                    Log.d("response data",it.data.toString())
                }
                Status.ERROR -> {
                    Log.d("response Error",it.message.toString())
                }
                Status.LOADING -> {
                    Log.d("response Error",it.message.toString())
                }
            }
        })

    }
}











//        val quote  = RetrofitHelper.getInstance().create(QuoteApi::class.java)
//        GlobalScope.launch {
//            val result = quote.getQuote(1)
//            if(result!=null){
//                Log.d("RETRO", result.body().toString())
//                val list = result.body()
//                if(list != null){
//                    list.results.forEach {
//                        Log.d("a",it.author)
//                    }
//                }
//            }
//        }




