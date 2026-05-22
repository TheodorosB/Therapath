package io.github.theodorosB.therapath.domain.user

interface UserRepository {

    suspend fun registerUser(password: String, email: String, username: String): Boolean

}