package io.github.theodorosB.therapath.ui.lobby.screens.home.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.theodorosB.therapath.ui.lobby.screens.home.model.HomeUiState
import io.github.theodorosB.therapath.ui.lobby.screens.home.viewmodel.HomeViewModel
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_12dp

@Composable
internal fun HomeScreen() {

    val viewModel: HomeViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = SpacingCustom_12dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 36.dp, alignment = Alignment.CenterVertically)
    ) {
        HomeContent(
            uiState = uiState
        )
    }
}

@Composable
private fun HomeContent(
    uiState: State<HomeUiState>
) {

}