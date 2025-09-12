package io.github.theodorosB.therapath.ui.login.screens.signup.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.theodorosB.therapath.ui.login.screens.signup.model.SignUpUiState
import io.github.theodorosB.therapath.ui.login.screens.signup.viewmodel.SignUpViewModel

@Composable
fun SignUpScreen() {
    val viewModel: SignUpViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    SignUpContent(
        uiState = uiState
    )
}

@Composable
fun SignUpContent(
    uiState: State<SignUpUiState>
) {

}