package io.github.theodorosB.therapath.ui.lobby.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.lobby.model.BottomNavBarItem
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
            onNavigateBackClicked = { onNavigateBackClicked() },
            onBottomNavClick = { bottomNavItem-> onBottomNavClick(item = bottomNavItem)}
        )
    )
    val uiState = _uiState.asStateFlow()

    private fun onBottomNavClick(item: BottomNavBarItem) {
        _uiState.value.lobbyBackStack.add(item.route)
        _uiState.value.bottomNavBar.forEach { it.isSelected.value = it == item }
    }
    private fun onNavigateBackClicked() {
        _uiState.value.bottomNavScreens.lastOrNull()
        val targetScreen = _uiState.value.bottomNavScreens.takeLast(2).firstOrNull()
        _uiState.value.lobbyBackStack.removeLastOrNull()
    }
}