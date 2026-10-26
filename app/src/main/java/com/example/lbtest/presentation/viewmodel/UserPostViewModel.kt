package com.example.lbtest.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lbtest.domain.model.APIResponse
import com.example.lbtest.domain.usecases.GetUserPostUseCase
import com.example.lbtest.presentation.model.UserPostUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserPostViewModel @Inject constructor(val getUserPostUseCase: GetUserPostUseCase): ViewModel() {

    private val _userPostState = MutableStateFlow<UserPostUIState>(UserPostUIState.LOADING)

    val userPostState: StateFlow<UserPostUIState>
        get() = _userPostState

    init {
       viewModelScope.launch(Dispatchers.IO) {
           when(val userPostResponse = getUserPostUseCase()) {
               is APIResponse.SUCCESS -> _userPostState.update { UserPostUIState.SUCCESS(userPostResponse.data) }
               is APIResponse.FAILURE -> _userPostState.update { UserPostUIState.ERROR(userPostResponse.error) }

           }
       }
    }
}