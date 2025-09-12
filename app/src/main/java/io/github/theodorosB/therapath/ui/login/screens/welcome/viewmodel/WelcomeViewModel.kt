package io.github.theodorosB.therapath.ui.login.screens.welcome.viewmodel

import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.login.screens.welcome.model.WelcomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class WelcomeViewModel @Inject constructor(
): BaseViewModel() {

    private val _uiState = MutableStateFlow(
        WelcomeUiState()
    )

    val uiState = _uiState.asStateFlow()
}