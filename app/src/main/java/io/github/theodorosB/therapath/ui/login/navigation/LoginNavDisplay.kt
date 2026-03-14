package io.github.theodorosB.therapath.ui.login.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import io.github.theodorosB.therapath.ui.login.model.LoginNavEntry
import io.github.theodorosB.therapath.ui.login.screens.resetpassword.composable.ResetPasswordScreen
import io.github.theodorosB.therapath.ui.login.screens.signin.composable.SignInScreen
import io.github.theodorosB.therapath.ui.login.screens.signup.composable.SignUpScreen
import io.github.theodorosB.therapath.ui.login.viewmodel.LoginViewModel
import io.github.theodorosB.therapath.ui.theme.ColorLoginBackground1
import io.github.theodorosB.therapath.ui.theme.ColorLoginBackground2

@Composable
internal fun LoginNavDisplay() {

    val viewModel: LoginViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    BackHandler {
        uiState.value.onNavigateBackClicked()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        ColorLoginBackground1,
                        ColorLoginBackground2
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.Top)
    ) {
        NavDisplay(
            backStack = uiState.value.loginBackStack,
            contentAlignment = Alignment.Center,
            transitionSpec = {
                val enter = slideInHorizontally { fullWidth -> fullWidth }
                val exit = slideOutHorizontally { fullWidth -> -fullWidth }
                enter togetherWith exit
            },
            popTransitionSpec = {
                val enter = slideInHorizontally { fullWidth -> -fullWidth }
                val exit = slideOutHorizontally { fullWidth -> fullWidth }
                enter togetherWith exit
            },
            entryProvider = { key ->
                when (key) {
                    LoginNavEntry.SignIn -> NavEntry(
                        key = key,
                        content = {
                            SignInScreen(
                                uiState = uiState
                            )
                        }
                    )

                    LoginNavEntry.SignUp -> NavEntry(
                        key = key,
                        content = {
                            SignUpScreen(
                                uiState = uiState
                            )
                        }
                    )

                    LoginNavEntry.ResetPassword -> NavEntry(
                        key = key,
                        content = {
                            ResetPasswordScreen(
                                uiState = uiState
                            )
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
}