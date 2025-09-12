package io.github.theodorosB.therapath.ui.dashboard.model

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.snapshots.SnapshotStateList

data class DashboardUiState(
    val navScreens: List<DashboardNavEntries> = listOf(
        DashboardNavEntries.Splash,
        DashboardNavEntries.Login,
        DashboardNavEntries.Lobby
    ),
    val backstackEntries: SnapshotStateList<DashboardNavEntries> = mutableStateListOf(
        DashboardNavEntries.Login
    )
)

sealed class DashboardNavEntries() {

    object Splash : DashboardNavEntries()
    object Login : DashboardNavEntries()
    object Lobby : DashboardNavEntries()
}

