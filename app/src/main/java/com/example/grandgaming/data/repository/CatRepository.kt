package com.example.grandgaming.data.repository

import com.example.grandgaming.data.model.APIItemItem
import com.example.grandgaming.data.network.RetrofitClient
import retrofit2.Response

class CatRepository {
    suspend fun getCatImages(): Response<List<APIItemItem>> {
     return   RetrofitClient.api.getImages()
    }
}