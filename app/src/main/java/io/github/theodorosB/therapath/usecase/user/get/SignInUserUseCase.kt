package io.github.theodorosB.therapath.usecase.user.get

import io.github.theodorosB.therapath.domain.user.UserRepository
import io.github.theodorosB.therapath.usecase.UseCase
import timber.log.Timber
import javax.inject.Inject

class SignInUserUseCase @Inject constructor(
    private val userRepository: UserRepository
): UseCase {

    suspend operator fun invoke(password: String, username: String): Boolean {
        return try {
            userRepository.signInUser(username = username, password = password)
        } catch (ex: Exception) {
            Timber.tag(SignInUserUseCase::class.simpleName.toString()).e(ex)
            false
        }
    }
}