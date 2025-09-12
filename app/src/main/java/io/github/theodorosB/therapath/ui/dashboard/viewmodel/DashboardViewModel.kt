package io.github.theodorosB.therapath.ui.dashboard.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.dashboard.model.DashboardUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(

): BaseViewModel() {

    private val _uiState = MutableStateFlow(DashboardUiState())
    val uiState = _uiState.asStateFlow()

}