package com.example.lbtest.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class ScreenRoute {
    @Serializable
    object UserPostScreen: ScreenRoute()
}