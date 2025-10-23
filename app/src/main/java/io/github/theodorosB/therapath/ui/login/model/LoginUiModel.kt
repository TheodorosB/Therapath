package io.github.theodorosB.therapath.ui.login.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import io.github.theodorosB.therapath.R
import io.github.theodorosB.therapath.ui.app.model.FieldUiItem

data class LoginUiState(
    val navScreens: List<LoginNavEntry> = listOf(
        LoginNavEntry.SignIn,
        LoginNavEntry.SignUp,
        LoginNavEntry.ResetPassword,
        LoginNavEntry.Welcome
    ),
    val title: MutableState<Int> = mutableIntStateOf(R.string.empty_string),
    val fields: SnapshotStateList<FieldUiItem> = mutableStateListOf(),
    val loginBackStack: SnapshotStateList<LoginNavEntry> = mutableStateListOf(LoginNavEntry.SignIn),
    val onSubmitClicked: () -> Unit,
    val onNavigateBackClicked: () -> Unit,
    val onNavigateToSignInScreen: () -> Unit,
    val onNavigateToSignUpScreen: () -> Unit,
    val onNavigateToResetPasswordScreen: () -> Unit,
) {
    val canResetPassword: Boolean
        get() = loginBackStack.lastOrNull { it is LoginNavEntry.SignIn } != null

    val isSubmitEnabled : Boolean
        get() = fields.all { it.isValid }

    val isPasswordMatched: Boolean
        get() {
            val isSignUpScreen = loginBackStack.lastOrNull { it is LoginNavEntry.SignUp } != null
            return if(isSignUpScreen) {
                val passwordField = fields.firstOrNull { it is FieldUiItem.Password }
                val confirmPasswordField = fields.firstOrNull { it is FieldUiItem.ConfirmPassword }
                passwordField?.text?.value == confirmPasswordField?.text?.value
            } else {
                true
            }
        }
}

sealed class LoginNavEntry {

    object SignIn: LoginNavEntry()

    object SignUp: LoginNavEntry()

    object ResetPassword: LoginNavEntry()

    object Welcome: LoginNavEntry()
}
