package ru.sagutdinov.repository

import ru.sagutdinov.model.AuthUserModel
import ru.sagutdinov.model.PostModel
import ru.sagutdinov.model.ReactionModel
import ru.sagutdinov.model.StatusUser
import ru.sagutdinov.service.ServicePost

interface UserRepository {
    suspend fun getAllPostsUser(): List<AuthUserModel>
    suspend fun getByIdUser(idUser: Long): AuthUserModel?
    suspend fun getByIdPassword(idUser: Long, password: String): AuthUserModel?
    suspend fun getByUsername(username: String): AuthUserModel?
    suspend fun getByUserStatus(user: AuthUserModel): StatusUser
    suspend fun getByIds(ids: Collection<Long>): List<AuthUserModel>
    suspend fun addUp(idUser: Long): AuthUserModel?
    suspend fun addDown(idUser: Long): AuthUserModel?
    suspend fun save(item: AuthUserModel): AuthUserModel
    suspend fun checkReadOnly(idUser: Long, postService: ServicePost): Boolean
    suspend fun addPostId(user: AuthUserModel, idPost: Long)
    suspend fun listUsersReaction(post: PostModel): List<ReactionModel>
}