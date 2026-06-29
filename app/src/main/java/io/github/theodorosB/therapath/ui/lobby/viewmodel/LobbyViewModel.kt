package io.github.theodorosB.therapath.ui.lobby.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.lobby.model.BottomNavEntry
import io.github.theodorosB.therapath.ui.lobby.model.LobbyUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class LobbyViewModel @Inject constructor(
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(
        LobbyUiState(
            onNavigateBackClicked = { onNavigateBackClicked() }
        )
    )
    val uiState = _uiState.asStateFlow()

    private fun navigateToMain() {
        val targetScreen = BottomNavEntry.Main
        _uiState.value.lobbyBackStack.add(targetScreen)
    }

    private fun navigateToMessages() {
        val targetScreen = BottomNavEntry.Messages
        _uiState.value.lobbyBackStack.add(targetScreen)
    }

    private fun navigateToSearch() {
        val targetScreen = BottomNavEntry.Search
        _uiState.value.lobbyBackStack.add(targetScreen)
    }

    private fun navigateToProfile() {
        val targetScreen = BottomNavEntry.Profile
        _uiState.value.lobbyBackStack.add(targetScreen)
    }
    private fun onNavigateBackClicked() {
        _uiState.value.bottomNavScreens.lastOrNull()
        val targetScreen = _uiState.value.bottomNavScreens.takeLast(2).firstOrNull()
        _uiState.value.lobbyBackStack.removeLastOrNull()
    }
}