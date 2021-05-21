package ru.sagutdinov.dto

import io.ktor.util.*
import ru.sagutdinov.model.Reaction
import ru.sagutdinov.model.ReactionModel
import ru.sagutdinov.model.StatusUser
import ru.sagutdinov.service.UserService
import java.time.format.DateTimeFormatter

data class ReactionsDto (
    val dateOfReaction: String,
    val idUser: Long,
    val userName: String,
    val status: StatusUser,
    val reaction: Reaction,
    val attachmentImage: String?
) {
    companion object {
        @KtorExperimentalAPI
        suspend fun fromModel(model: ReactionModel, userService: UserService): ReactionsDto {
            val formatter = DateTimeFormatter.ofPattern("dd.MM.YYYY")
            val date = model.date.format(formatter)


            return ReactionsDto(
                dateOfReaction = date,
                idUser = model.user.idUser,
                userName = model.user.username,
                status = userService.checkStatus(model.user.idUser),
                reaction = model.reaction,
                attachmentImage = model.user.attachmentImage
            )
        }
    }
}