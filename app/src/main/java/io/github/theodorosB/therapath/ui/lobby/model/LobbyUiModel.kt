package io.github.theodorosB.therapath.ui.lobby.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import io.github.theodorosB.therapath.ui.login.model.LoginNavEntry

data class LobbyUiState(
    val bottomNavScreens: List<BottomNavEntry> = listOf(
        BottomNavEntry.Main,
        BottomNavEntry.Search,
        BottomNavEntry.Messages,
        BottomNavEntry.Profile
    ),
    val lobbyBackStack: SnapshotStateList<BottomNavEntry> = mutableStateListOf(BottomNavEntry.Main),
    val onNavigateBackClicked: () -> Unit
)

sealed class BottomNavEntry {

    object Main: BottomNavEntry()
    object Search: BottomNavEntry()
    object Messages: BottomNavEntry()

    object Profile: BottomNavEntry()
}