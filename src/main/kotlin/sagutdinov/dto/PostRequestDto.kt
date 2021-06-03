package ru.sagutdinov.dto


data class PostRequestDto (
    val postName: String? = null,
    val postText: String? = null,
    val attachmentImage: String,
    val link: String? = null
)