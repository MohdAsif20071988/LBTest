package com.example.lbtest.di.network

import com.example.lbtest.common.BASE_URL
import com.example.lbtest.data.network.UserPostAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Provides
    @Singleton
    fun getBaseURL(): String = BASE_URL

    @Provides
    @Singleton
    fun getRetrofit(baseURL: String): Retrofit = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(
        GsonConverterFactory.create()).build()

    @Provides
    @Singleton
    fun getUserPostAPI(retrofit: Retrofit): UserPostAPI = retrofit.create<UserPostAPI>(UserPostAPI::class.java)
}