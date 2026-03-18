package io.github.theodorosB.therapath.data.user

import io.github.theodorosB.therapath.domain.user.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userDataSourceImpl: UserDataSource
): UserRepository {

    override suspend fun registerUser(password: String, email: String, username: String) {
        userDataSourceImpl.registerUser(password = password, email = email,username = username)
    }

}