package io.github.theodorosB.therapath.ui.login.screens.signin.viewmodel

import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.login.screens.signin.model.SignInUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SignInViewModel @Inject constructor(

): BaseViewModel() {

    private val _uiState = MutableStateFlow(
        SignInUiState(
            onSignInClicked = {},
            onUpdateText = {}
        )
    )

    val uiState = _uiState.asStateFlow()
}