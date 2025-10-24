package io.github.theodorosB.therapath.ui.login.screens.signin.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.res.stringResource
import io.github.theodorosB.therapath.R
import io.github.theodorosB.therapath.ui.login.composable.LoginScreen
import io.github.theodorosB.therapath.ui.login.model.LoginUiState

@Composable
fun SignInScreen(
    uiState: State<LoginUiState>
) {

    SignInContent(
        uiState = uiState
    )
}

@Composable
fun SignInContent(
    uiState: State<LoginUiState>
) {
    LoginScreen(
        fields = uiState.value.fields,
        title = stringResource(id = uiState.value.title.value),
        navTitle = stringResource(id = R.string.sign_up_title),
        navDescription = stringResource(id = R.string.login_dont_have_account),
        canResetPassword = uiState.value.canResetPassword,
        onSubmitClicked = uiState.value.onSubmitClicked,
        submitButtonText = stringResource(id = R. string.login_sign_in_title),
        onNavScreenClicked = uiState.value.onNavScreenClicked,
        onForgotPasswordClicked = uiState.value.onNavigateToResetPasswordScreen
    )
}
