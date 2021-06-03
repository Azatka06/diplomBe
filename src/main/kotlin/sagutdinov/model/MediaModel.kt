package ru.sagutdinov.model

import javax.ws.rs.core.MediaType

enum class MediaType {
    IMAGE
}


data class MediaModel(val id: String, val mediaType: ru.sagutdinov.model.MediaType)
