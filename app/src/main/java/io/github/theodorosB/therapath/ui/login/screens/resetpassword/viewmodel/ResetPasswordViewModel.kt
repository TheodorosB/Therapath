package io.github.theodorosB.therapath.ui.login.screens.resetpassword.viewmodel

import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.login.screens.resetpassword.model.ResetPasswordUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class ResetPasswordViewModel @Inject constructor(
): BaseViewModel() {

    private val _uiState = MutableStateFlow(
        ResetPasswordUiState(
            onSignUpClicked = {},
            onUpdateText = {}
        )
    )

    val uiState = _uiState.asStateFlow()
}