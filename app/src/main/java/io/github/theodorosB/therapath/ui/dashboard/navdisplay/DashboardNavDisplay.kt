package io.github.theodorosB.therapath.ui.dashboard.navdisplay

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import io.github.theodorosB.therapath.ui.dashboard.model.DashboardNavEntries
import io.github.theodorosB.therapath.ui.dashboard.viewmodel.DashboardViewModel
import io.github.theodorosB.therapath.ui.login.navigation.LoginNavDisplay
import io.github.theodorosB.therapath.ui.theme.ColorBaseBackground

@Composable
fun DashboardNavDisplay(
    modifier: Modifier = Modifier
) {
    val viewModel: DashboardViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = ColorBaseBackground),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 8.dp, alignment = Alignment.Top)
    ) {

        NavDisplay(
            modifier = Modifier
                .padding(horizontal = 8.dp),
            backStack = uiState.value.backstackEntries,
            contentAlignment = Alignment.Center,
            entryProvider = { key ->
                when (key) {
                    DashboardNavEntries.Splash -> NavEntry(
                        key = key,
                        content = {
                        }
                    )

                    DashboardNavEntries.Login -> NavEntry(
                        key = key,
                        content = {
                            LoginNavDisplay()
                        }
                    )
                    DashboardNavEntries.Lobby -> NavEntry(
                        key = key,
                        content = {
                        }
                    )
                }
            }
        )
    }
}