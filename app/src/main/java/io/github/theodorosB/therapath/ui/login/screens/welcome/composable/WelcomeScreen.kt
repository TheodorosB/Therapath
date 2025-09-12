package io.github.theodorosB.therapath.ui.login.screens.welcome.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.theodorosB.therapath.ui.login.screens.welcome.model.WelcomeUiState
import io.github.theodorosB.therapath.ui.login.screens.welcome.viewmodel.WelcomeViewModel

@Composable
fun WelcomeScreen() {
    val viewModel: WelcomeViewModel = hiltViewModel()
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()

    WelcomeContent(
        uiState = uiState
    )
}

@Composable
fun WelcomeContent(
    uiState: State<WelcomeUiState>
) {

}