package ru.sagutdinov.dto

import ru.sagutdinov.model.MediaModel
import ru.sagutdinov.model.MediaType

data class MediaResponseDto(val id: String, val mediaType: MediaType) {
    companion object {
        fun fromModel(model: MediaModel) = MediaResponseDto(
            id = model.id,
            mediaType = model.mediaType

        )
    }
}