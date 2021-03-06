package ru.sagutdinov.dto

import io.ktor.util.*
import ru.sagutdinov.model.PostModel
import ru.sagutdinov.model.StatusUser
import ru.sagutdinov.service.UserService
import java.time.format.DateTimeFormatter

data class PostResponseDto(
    val idPost: Long,
    val userName: String?,
    val postName: String? = null,
    val postText: String? = null,
    val link: String? = null,
    val dateOfCreate: String? = null,
    val attachmentImage: String,
    var postUpCount: Int,
    var postDownCount: Int,
    var pressedPostUp: Boolean,
    var pressedPostDown: Boolean,
    var statusUser: StatusUser = StatusUser.NONE,
    val idUser: Long,
    val attachmentId: String? = null
) {
    companion object {
        @KtorExperimentalAPI
        suspend fun fromModel(postModel: PostModel, userService: UserService, idUser: Long):
                PostResponseDto {
            val userFromModel = userService.getByIdUser(postModel.idUser)
            val pressedPostUp = postModel.upUserIdMap.contains(userFromModel.idUser)
            val pressedPostDown = postModel.downUserIdMap.contains(userFromModel.idUser)
            val postUpCount = postModel.upUserIdMap.size
            val postDownCount = postModel.downUserIdMap.size
            val formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy")
            val dateOfPostString = postModel.dateOfCreate.format(formatter)
            val status = userService.checkStatus(postModel.idUser)

            return PostResponseDto(
                idPost = postModel.idPost,
                userName = userFromModel.username,
                dateOfCreate = dateOfPostString,
                postName = postModel.postName,
                attachmentImage = postModel.attachmentImage,
                postText = postModel.postText,
                postUpCount = postUpCount,
                pressedPostUp = pressedPostUp,
                pressedPostDown = pressedPostDown,
                postDownCount = postDownCount,
                idUser = userFromModel.idUser,
                statusUser = status,
                link = postModel.link,
                attachmentId = postModel.attachment?.id
            )
        }
    }
}

