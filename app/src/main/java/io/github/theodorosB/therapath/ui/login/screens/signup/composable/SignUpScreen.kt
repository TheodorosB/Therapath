package io.github.theodorosB.therapath.ui.login.screens.signup.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.res.stringResource
import io.github.theodorosB.therapath.R
import io.github.theodorosB.therapath.ui.login.composable.LoginScreen
import io.github.theodorosB.therapath.ui.login.model.LoginUiState

@Composable
fun SignUpScreen(
    uiState: State<LoginUiState>
) {

    SignUpContent(
        uiState = uiState
    )
}

@Composable
fun SignUpContent(
    uiState: State<LoginUiState>
) {
    LoginScreen(
        fields = uiState.value.fields,
        isSubmitEnabled = uiState.value.isSubmitEnabled,
        title = stringResource(id = uiState.value.title.value),
        navTitle = stringResource(id = R.string.login_sign_in_title),
        navDescription = stringResource(id = R.string.sign_up_already_have_account),
        submitButtonText = stringResource(id = R. string.sign_up_title),
        canResetPassword = uiState.value.canResetPassword,
        onSubmitClicked = uiState.value.onSubmitClicked,
        onNavScreenClicked = uiState.value.onNavScreenClicked,
        onForgotPasswordClicked = uiState.value.onNavigateToResetPasswordScreen
    )
}