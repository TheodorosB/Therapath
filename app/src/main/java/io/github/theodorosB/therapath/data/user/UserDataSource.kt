package io.github.theodorosB.therapath.data.user

interface UserDataSource {

    suspend fun registerUser(password: String, email: String, username: String): Boolean
    suspend fun signInUser(username: String, password: String): Boolean
}