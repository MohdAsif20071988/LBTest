package com.example.lbtest.domain.model

sealed class APIResponse<T> {
    data class SUCCESS<T>(val data: T): APIResponse<T>()
    data class FAILURE<T>(val error: String): APIResponse<T>()
}