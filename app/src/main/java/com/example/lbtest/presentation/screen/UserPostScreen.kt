package com.example.lbtest.presentation.screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.lbtest.presentation.model.UserPostUIState
import com.example.lbtest.presentation.viewmodel.UserPostViewModel

@Composable
fun UserPostScreen(viewModel: UserPostViewModel) {

    val userPostState by viewModel.userPostState.collectAsStateWithLifecycle()

    when (userPostState) {
        is UserPostUIState.LOADING -> {
            CircularProgressIndicator()
        }
        is UserPostUIState.SUCCESS -> {
            LazyColumn(modifier = Modifier.fillMaxSize().padding(10.dp)) {
                items((userPostState as UserPostUIState.SUCCESS).userPost, key = {it.id}) {
                    Text(it.title)
                }
            }
        }
        is UserPostUIState.ERROR -> {
            Text((userPostState as UserPostUIState.ERROR).error)
        }
    }
}