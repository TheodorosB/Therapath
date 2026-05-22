package io.github.theodorosB.therapath.domain.user

interface UserRepository {

    suspend fun registerUser(password: String, email: String, username: String): Boolean
    suspend fun signInUser(username: String, password: String): Boolean
}