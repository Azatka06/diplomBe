package ru.sagutdinov.dto


data class PostRequestDto (
    val postName: String? = null,
    val postText: String? = null,
    val link: String? = null,
    val attachmentImage: String
)