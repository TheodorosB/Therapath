package io.github.theodorosB.therapath.ui.login.screens.resetpassword.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.theodorosB.therapath.ui.login.screens.resetpassword.model.ResetPasswordUiState
import io.github.theodorosB.therapath.ui.login.screens.resetpassword.viewmodel.ResetPasswordViewModel

@Composable
fun ResetPasswordScreen() {

    val viewModel: ResetPasswordViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    ResetPasswordContent(
        uiState = uiState
    )

}

@Composable
fun ResetPasswordContent(
    uiState: State<ResetPasswordUiState>
) {

}