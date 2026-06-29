package io.github.theodorosB.therapath.ui.lobby.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import io.github.theodorosB.therapath.ui.lobby.model.BottomNavEntry
import io.github.theodorosB.therapath.ui.lobby.viewmodel.LobbyViewModel
import io.github.theodorosB.therapath.ui.theme.ColorLoginBackground1
import io.github.theodorosB.therapath.ui.theme.ColorLoginBackground2
import io.github.theodorosB.therapath.ui.theme.SpacingHalf_8dp

@Composable
internal fun LobbyNavDisplay() {

    val viewModel: LobbyViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    BackHandler {
        uiState.value.onNavigateBackClicked()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        ColorLoginBackground1,
                        ColorLoginBackground2
                    )
                )
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = SpacingHalf_8dp, alignment = Alignment.Top)
    ) {
        NavDisplay(
            backStack = uiState.value.lobbyBackStack,
            contentAlignment = Alignment.Center,
            transitionSpec = {
                val enter = slideInHorizontally { fullWidth -> fullWidth }
                val exit = slideOutHorizontally { fullWidth -> -fullWidth }
                enter togetherWith exit
            },
            popTransitionSpec = {
                val enter = slideInHorizontally { fullWidth -> -fullWidth }
                val exit = slideOutHorizontally { fullWidth -> fullWidth }
                enter togetherWith exit
            },
            entryProvider = { key ->
                when (key) {
                    BottomNavEntry.Main -> NavEntry(
                        key = key,
                        content = {

                        }
                    )

                    BottomNavEntry.Search -> NavEntry(
                        key = key,
                        content = {

                        }
                    )

                    BottomNavEntry.Messages -> NavEntry(
                        key = key,
                        content = {

                        }
                    )

                    BottomNavEntry.Profile -> NavEntry(
                        key = key,
                        content = {

                        }
                    )
                }
            }
        )
    }
}