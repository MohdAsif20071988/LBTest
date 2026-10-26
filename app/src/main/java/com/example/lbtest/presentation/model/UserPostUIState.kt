package com.example.lbtest.presentation.model

import com.example.lbtest.domain.model.UserPost

sealed class UserPostUIState {
    object LOADING: UserPostUIState()
    data class SUCCESS(val userPost: List<UserPost>): UserPostUIState()
    data class ERROR(val error: String): UserPostUIState()
}