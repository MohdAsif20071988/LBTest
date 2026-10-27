package com.example.lbtest.presentation.viewmodel

import app.cash.turbine.test
import com.example.lbtest.domain.model.APIResponse
import com.example.lbtest.domain.model.UserPost
import com.example.lbtest.domain.usecases.GetUserPostUseCase
import com.example.lbtest.presentation.model.UserPostUIState
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Rule
import org.junit.Test

class UserPostViewModelTest {

    @get:Rule val testDispatcher = MainTestDispatcher()

    private val getUserPostUseCase = mockk<GetUserPostUseCase>()

    lateinit var userPostViewModel: UserPostViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `test user post success`() = runTest {
        val data = listOf(UserPost("body", 101, "title", 1001))
        coEvery { getUserPostUseCase() } returns APIResponse.SUCCESS(data)

        userPostViewModel = UserPostViewModel(getUserPostUseCase)
        userPostViewModel.userPostState.test {
            assert(awaitItem() is UserPostUIState.SUCCESS)

            cancelAndIgnoreRemainingEvents()
        }

        coVerify(exactly = 1) {
            getUserPostUseCase()
        }
    }

    @Test
    fun `test user post failure`() = runTest {
        coEvery { getUserPostUseCase() } returns APIResponse.FAILURE("Error!")

        userPostViewModel = UserPostViewModel(getUserPostUseCase)
        userPostViewModel.userPostState.test {
            assert(awaitItem() is UserPostUIState.ERROR)

            cancelAndIgnoreRemainingEvents()
        }

        coVerify(exactly = 1) {
            getUserPostUseCase()
        }
    }

   @After
    fun tearDown() {
       clearAllMocks()
    }
}