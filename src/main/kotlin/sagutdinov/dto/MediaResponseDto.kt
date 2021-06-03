package ru.sagutdinov.dto

import ru.sagutdinov.model.MediaModel


data class MediaResponseDto(val id: String) {
    companion object {
        fun fromModel(model: MediaModel) = MediaResponseDto(
            id = model.id
        )
    }
}