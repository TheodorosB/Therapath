package io.github.theodorosB.therapath.ui.user.model

data class UserUiItem(
    val uuid: Int,
    val name: String = "",
    val email: String = "",
    val password: String = ""
)
