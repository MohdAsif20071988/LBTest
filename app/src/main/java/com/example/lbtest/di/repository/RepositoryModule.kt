package com.example.lbtest.di.repository

import com.example.lbtest.data.repository.UserRepositoryImpl
import com.example.lbtest.domain.repository.UserPostRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent:: class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun getRetrofit(repositoryImpl: UserRepositoryImpl): UserPostRepository
}