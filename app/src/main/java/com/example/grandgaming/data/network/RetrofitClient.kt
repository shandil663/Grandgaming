package com.example.grandgaming.data.network

import com.example.grandgaming.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private val retrofit by lazy {
            Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build()
        }

        val api by lazy {
            retrofit.create(ApiServices::class.java)
        }
    }
}