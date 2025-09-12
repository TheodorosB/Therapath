package io.github.theodorosB.therapath.ui.login.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.login.model.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(

): BaseViewModel() {

    private val _uiState = MutableStateFlow(
        LoginUiState(
            onNavigateBackClicked = { onNavigateBackClicked() }
        )
    )

    val uiState = _uiState.asStateFlow()

    private fun onNavigateBackClicked() {
        _uiState.value.loginBackStack.removeLastOrNull()
    }
}