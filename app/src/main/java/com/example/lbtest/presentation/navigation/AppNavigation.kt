package com.example.lbtest.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lbtest.presentation.screen.UserPostScreen
import com.example.lbtest.presentation.viewmodel.UserPostViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, ScreenRoute.UserPostScreen) {
        composable<ScreenRoute.UserPostScreen> {
            val userPostViewModel = hiltViewModel<UserPostViewModel>()

            UserPostScreen(userPostViewModel)
        }
    }
}