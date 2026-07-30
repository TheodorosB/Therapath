package io.github.theodorosB.therapath.ui.lobby.screens.home.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.lobby.screens.home.model.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(
        HomeUiState(

        )
    )
    val uiState = _uiState.asStateFlow()
}