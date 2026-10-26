package com.example.lbtest.domain.repository

import com.example.lbtest.domain.model.APIResponse
import com.example.lbtest.domain.model.UserPost

interface UserPostRepository {
    suspend fun getUserPost(): APIResponse<List<UserPost>>
}