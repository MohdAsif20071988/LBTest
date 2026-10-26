package com.example.lbtest.data.repository

import com.example.lbtest.data.model.toDomain
import com.example.lbtest.data.network.UserPostAPI
import com.example.lbtest.domain.model.APIResponse
import com.example.lbtest.domain.model.UserPost
import com.example.lbtest.domain.repository.UserPostRepository
import kotlinx.coroutines.CancellationException
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val userPostAPI: UserPostAPI): UserPostRepository {
    override suspend fun getUserPost(): APIResponse<List<UserPost>> {
        try {
            val apiResponse = userPostAPI.getUserPost()
            if (apiResponse.isSuccessful && apiResponse.body() != null) {
                return APIResponse.SUCCESS((apiResponse.body()!!.map { it.toDomain() }).filter { it.title.first() in "aeiou" })
            } else {
                return APIResponse.FAILURE("Something went wrong!")
            }
        } catch (cancellationException: CancellationException) {
            throw cancellationException
        } catch (exception: Exception) {
            return APIResponse.FAILURE(exception.message.toString())
        }
    }
}