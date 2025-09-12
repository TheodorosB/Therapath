package io.github.theodorosB.therapath.ui.login.screens.resetpassword.model

import io.github.theodorosB.therapath.ui.app.model.FieldUiItem

data class ResetPasswordUiState(
    val fields: List<FieldUiItem> = listOf(
        FieldUiItem.Username()
    ),
    val onUpdateText: () -> Unit,
    val onSignUpClicked: () -> Unit,
)
