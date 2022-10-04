package com.example.friends.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Controller {
    companion object {

        fun getRetrofitInstance(path : String) : Retrofit {
            return Retrofit.Builder()
//                .baseUrl("https://reqres.in/api/$path")
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}