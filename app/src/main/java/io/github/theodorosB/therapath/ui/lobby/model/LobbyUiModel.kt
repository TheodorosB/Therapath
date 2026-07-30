package io.github.theodorosB.therapath.ui.lobby.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.snapshots.SnapshotStateList
import io.github.theodorosB.therapath.R

data class LobbyUiState(
    val bottomNavScreens: List<BottomNavEntry> = listOf(
        BottomNavEntry.Home,
        BottomNavEntry.Search,
        BottomNavEntry.Calendar,
        BottomNavEntry.Messages,
        BottomNavEntry.Profile
    ),
    val lobbyBackStack: SnapshotStateList<BottomNavEntry> = mutableStateListOf(BottomNavEntry.Home),
    val bottomNavBar: List<BottomNavBarItem> = bottomNavItems,
    val onBottomNavClick: (BottomNavBarItem) -> Unit,
    val onNavigateBackClicked: () -> Unit
) {
    companion object {
        private val bottomNavItems = listOf(
            BottomNavBarItem.Home,
            BottomNavBarItem.Search,
            BottomNavBarItem.Calendar,
            BottomNavBarItem.Messages,
            BottomNavBarItem.Profile
        )
    }
}

sealed class BottomNavEntry {

    object Home: BottomNavEntry()
    object Search: BottomNavEntry()
    object Calendar: BottomNavEntry()
    object Messages: BottomNavEntry()

    object Profile: BottomNavEntry()
}

sealed class BottomNavBarItem(
    @DrawableRes val icon: Int,
    @StringRes val title: Int,
    val route: BottomNavEntry,
    val isSelected: MutableState<Boolean> = mutableStateOf(false)
) {
    object Home: BottomNavBarItem(
        icon = R.drawable.ic_bottom_nav_home,
        title = R.string.lobby_bottom_nav_home,
        route = BottomNavEntry.Home,
        isSelected = mutableStateOf(true)
    )
    object Search: BottomNavBarItem(
        icon = R.drawable.ic_bottom_nav_search,
        title = R.string.lobby_bottom_nav_search,
        route = BottomNavEntry.Search
    )
    object Calendar: BottomNavBarItem(
        icon = R.drawable.ic_bottom_nav_calendar,
        title = R.string.lobby_bottom_nav_calendar,
        route = BottomNavEntry.Calendar
    )
    object Messages: BottomNavBarItem(
        icon = R.drawable.ic_bottom_nav_messages,
        title = R.string.lobby_bottom_nav_messages,
        route = BottomNavEntry.Messages
    )
    object Profile: BottomNavBarItem(
        icon = R.drawable.ic_bottom_nav_profile,
        title = R.string.lobby_bottom_nav_profile,
        route = BottomNavEntry.Profile
    )
}