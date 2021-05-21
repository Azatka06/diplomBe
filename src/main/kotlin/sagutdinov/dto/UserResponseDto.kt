package ru.sagutdinov.dto

import io.ktor.util.*
import ru.sagutdinov.model.StatusUser
import ru.sagutdinov.service.ServicePost
import ru.sagutdinov.service.UserService

data class UserResponseDto(
    val idUser: Long,
    val username: String,
    val attachmentImage: String?,
    var statusUser: StatusUser,
    val token: String?,
    var readOnly: Boolean
) {
    companion object {
        @KtorExperimentalAPI
        suspend fun fromModel(idUser: Long, userService: UserService, postService: ServicePost): UserResponseDto {
            val user = userService.getByIdUser(idUser)
            return UserResponseDto(
                idUser = user.idUser,
                username = user.username,
                attachmentImage = user.attachmentImage,
                statusUser = userService.checkStatus(user.idUser),
                token = user.token,
                readOnly = userService.checkReadOnly(user.idUser, postService)
            )
        }
    }
}
