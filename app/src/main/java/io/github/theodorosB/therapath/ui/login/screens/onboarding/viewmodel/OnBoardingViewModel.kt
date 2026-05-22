package io.github.theodorosB.therapath.ui.login.screens.onboarding.viewmodel

import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.login.screens.onboarding.model.OnBoardingUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

class OnBoardingViewModel @Inject constructor(
): BaseViewModel() {

    private val _uiState = MutableStateFlow(
        OnBoardingUiState()
    )

    val uiState = _uiState.asStateFlow()
}