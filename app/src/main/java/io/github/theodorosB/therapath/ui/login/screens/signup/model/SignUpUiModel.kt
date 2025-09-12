package io.github.theodorosB.therapath.ui.login.screens.signup.model

import io.github.theodorosB.therapath.ui.app.model.FieldUiItem

data class SignUpUiState(
    val fields: List<FieldUiItem> = listOf(
        FieldUiItem.Username(),
        FieldUiItem.Password()
    ),
    val onUpdateText: () -> Unit,
    val onSignUpClicked: () -> Unit,
)
