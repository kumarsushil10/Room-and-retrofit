package com.kmrsushil.myapp.api

import com.kmrsushil.myapp.model.MyDataModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("posts")
    suspend fun getData(): Response<MyDataModel>
}