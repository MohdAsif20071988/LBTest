package com.example.lbtest.data.model

import com.example.lbtest.domain.model.UserPost

fun UserPostDTO.toDomain(): UserPost {
    return UserPost(
        body = this.body,
        id = this.id,
        title = this.title,
        userId = this.userId
    )
}