package ru.sagutdinov.dto

data class UserRequestDto (
    val username: String,
    val password: String,
    val attachmentImage: String? = null
)