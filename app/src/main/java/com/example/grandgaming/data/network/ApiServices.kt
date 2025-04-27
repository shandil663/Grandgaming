package com.example.grandgaming.data.network

import com.example.grandgaming.data.model.APIItemItem
import com.example.grandgaming.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiServices {

    @GET(Constants.GET_IMAGES)
    suspend fun getImages(): Response<List<APIItemItem>>

}