package io.github.theodorosB.therapath.ui.login.screens.signup.viewmodel

import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.login.screens.signup.model.SignUpUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class SignUpViewModel @Inject constructor(
): BaseViewModel() {

    private val _uiState = MutableStateFlow(
        SignUpUiState(
            onSignUpClicked = {},
            onUpdateText = {}
        )
    )

    val uiState = _uiState.asStateFlow()
}