package com.example.lbtest.domain.usecases

import com.example.lbtest.data.repository.UserRepositoryImpl
import com.example.lbtest.domain.model.APIResponse
import com.example.lbtest.domain.model.UserPost
import jakarta.inject.Inject

class GetUserPostUseCase @Inject constructor(val userPostRepository: UserRepositoryImpl) {
    suspend operator fun invoke(): APIResponse<List<UserPost>> {
        return  userPostRepository.getUserPost()
    }
}