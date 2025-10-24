package io.github.theodorosB.therapath.ui.login.screens.resetpassword.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.res.stringResource
import io.github.theodorosB.therapath.R
import io.github.theodorosB.therapath.ui.login.composable.LoginScreen
import io.github.theodorosB.therapath.ui.login.model.LoginUiState

@Composable
fun ResetPasswordScreen(
    uiState: State<LoginUiState>
) {

    ResetPasswordContent(
        uiState = uiState
    )

}

@Composable
fun ResetPasswordContent(
    uiState: State<LoginUiState>
) {
    LoginScreen(
        fields = uiState.value.fields,
        title = stringResource(id = uiState.value.title.value),
        navTitle = stringResource(id = R.string.login_sign_in_title),
        navDescription = stringResource(id = R.string.sign_up_already_have_account),
        submitButtonText = stringResource(id = R. string.login_next),
        canResetPassword = uiState.value.canResetPassword,
        onSubmitClicked = uiState.value.onSubmitClicked,
        onNavScreenClicked = uiState.value.onNavScreenClicked,
        onForgotPasswordClicked = uiState.value.onNavigateToResetPasswordScreen
    )
}