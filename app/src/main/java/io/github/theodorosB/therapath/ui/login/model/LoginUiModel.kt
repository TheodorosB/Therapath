package io.github.theodorosB.therapath.ui.login.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class LoginUiState(
    val navScreens: List<LoginNavEntry> = listOf(
        LoginNavEntry.SignIn,
        LoginNavEntry.SignUp,
        LoginNavEntry.ResetPassword,
        LoginNavEntry.Welcome
    ),
    val loginBackStack: SnapshotStateList<LoginNavEntry> = mutableStateListOf(),
    val onNavigateBackClicked: (Int) -> Unit,
)

sealed class LoginNavEntry {

    object SignIn: LoginNavEntry()

    object SignUp: LoginNavEntry()

    object ResetPassword: LoginNavEntry()

    object Welcome: LoginNavEntry()
}
