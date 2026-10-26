package com.example.lbtest.data.network

import com.example.lbtest.data.model.UserPostDTO
import retrofit2.Response
import retrofit2.http.GET

interface UserPostAPI {
    @GET("/posts")
    suspend fun getUserPost(): Response<List<UserPostDTO>>
}