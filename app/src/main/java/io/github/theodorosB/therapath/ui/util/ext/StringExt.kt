package io.github.theodorosB.therapath.ui.util.ext

fun String.isValidEmail(): Boolean {
    val emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    return this.matches(emailPattern.toRegex())
}

fun String.hasSpecialCharacter(): Boolean {
    val specialCharPattern = "[!@#\$%^&*(),.?\":{}|<>~\\-_=+\\[\\]/\\\\]"
    return this.any { it.toString().matches(specialCharPattern.toRegex()) }
}