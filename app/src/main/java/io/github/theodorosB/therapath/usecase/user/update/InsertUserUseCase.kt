package io.github.theodorosB.therapath.usecase.user.update

import io.github.theodorosB.therapath.domain.user.UserRepository
import io.github.theodorosB.therapath.usecase.UseCase
import timber.log.Timber
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(
    private val userRepository: UserRepository
): UseCase {

    suspend operator fun invoke(password: String, email: String, username: String) {
        try {
            userRepository.registerUser(username = username, password = password, email = email)
        } catch (ex: Exception) {
            Timber.tag(RegisterUserUseCase::class.simpleName.toString()).e(ex)
        }
    }

}