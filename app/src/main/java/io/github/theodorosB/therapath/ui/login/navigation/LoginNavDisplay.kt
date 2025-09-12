package io.github.theodorosB.therapath.ui.login.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import io.github.theodorosB.therapath.ui.login.model.LoginNavEntry
import io.github.theodorosB.therapath.ui.login.screens.resetpassword.composable.ResetPasswordScreen
import io.github.theodorosB.therapath.ui.login.viewmodel.LoginViewModel
import io.github.theodorosB.therapath.ui.login.screens.signin.composable.SignInScreen
import io.github.theodorosB.therapath.ui.login.screens.signup.composable.SignUpScreen

@Composable
fun LoginNavDisplay() {

    val viewModel: LoginViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    NavDisplay(
        backStack = uiState.value.loginBackStack,
        contentAlignment = Alignment.Center,
        entryProvider = { key ->
            when(key) {
                LoginNavEntry.SignIn -> NavEntry(
                    key = key,
                    content = {
                        SignInScreen()
                    }
                )
                LoginNavEntry.SignUp -> NavEntry(
                    key = key,
                    content = {
                        SignUpScreen()
                    }
                )
                LoginNavEntry.ResetPassword -> NavEntry(
                    key = key,
                    content = {
                        ResetPasswordScreen()
                    }
                )
                LoginNavEntry.Welcome -> NavEntry(
                    key = key,
                    content = {
                    }
                )
            }

        }
    )
}