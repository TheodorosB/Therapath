package io.github.theodorosB.therapath.ui.login.screens.signin.model

import io.github.theodorosB.therapath.ui.app.model.FieldUiItem

data class SignInUiState(
    val fields: List<FieldUiItem> = listOf(
        FieldUiItem.Username(),
        FieldUiItem.Email(),
        FieldUiItem.Password()
    ),
    val onUpdateText: () -> Unit,
    val onSignInClicked: () -> Unit,
)