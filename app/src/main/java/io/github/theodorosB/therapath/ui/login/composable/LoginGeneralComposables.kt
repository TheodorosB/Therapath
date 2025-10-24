package io.github.theodorosB.therapath.ui.login.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.theodorosB.therapath.R
import io.github.theodorosB.therapath.ui.app.model.FieldUiItem
import io.github.theodorosB.therapath.ui.theme.ColorBaseBackground
import io.github.theodorosB.therapath.ui.theme.ColorFadedBlack
import io.github.theodorosB.therapath.ui.theme.ColorLoginBackground1
import io.github.theodorosB.therapath.ui.theme.ColorLoginBackground2
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_12dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_24dp
import io.github.theodorosB.therapath.ui.theme.SpacingCustom_36dp
import io.github.theodorosB.therapath.ui.theme.SpacingDefault_16dp

@Composable
internal fun LoginScreen(
    title: String,
    navTitle: String,
    navDescription: String,
    submitButtonText: String,
    fields: List<FieldUiItem>,
    canResetPassword: Boolean,
    onSubmitClicked: () -> Unit,
    onNavScreenClicked: () -> Unit,
    onForgotPasswordClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = SpacingCustom_12dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(space = 36.dp, alignment = Alignment.CenterVertically)
    ) {
        LoginTitleRow(
            title = title
        )

        LoginContent(
            fields = fields,
            canResetPassword = canResetPassword,
            onSubmitClicked = onSubmitClicked,
            navTitle = navTitle,
            navDescription = navDescription,
            submitButtonText = submitButtonText,
            onNavScreenClicked = onNavScreenClicked,
            onForgotPasswordClicked = onForgotPasswordClicked
        )
    }
}

@Composable
private fun LoginTitleRow(
    title: String
) {
    Row(
       modifier = Modifier
           .fillMaxWidth()
           .aspectRatio(2f)
           .padding(all = SpacingCustom_24dp)
           .padding(top = SpacingCustom_12dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.displaySmall,
            textAlign = TextAlign.Center,
            color = Color.White
        )
    }
}

@Composable
private fun LoginContent(
    fields: List<FieldUiItem>,
    submitButtonText: String,
    navTitle: String,
    navDescription: String,
    canResetPassword: Boolean,
    onSubmitClicked: () -> Unit,
    onNavScreenClicked: () -> Unit,
    onForgotPasswordClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = ColorBaseBackground,
                shape = RoundedCornerShape(
                    topStart = SpacingCustom_36dp,
                    topEnd = SpacingCustom_36dp
                )
            )
            .padding(horizontal = SpacingDefault_16dp, vertical = SpacingCustom_36dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(
                space = 24.dp,
                alignment = Alignment.CenterVertically
            ),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(items = fields, key = { it.text }) { field ->
                FieldItem(
                    field = field
                )
            }
            item {
                if(canResetPassword) {
                    LoginForgotPassword(
                        onForgotPasswordClicked = onForgotPasswordClicked
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(0.7f)
                .aspectRatio(5f)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            ColorLoginBackground1,
                            ColorLoginBackground2
                        )
                    ),
                    shape = RoundedCornerShape(SpacingCustom_36dp)
                )
                .clickable {
                    onSubmitClicked()
                },
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = submitButtonText,
                style = MaterialTheme.typography.titleLarge.copy(fontSize = 25.sp),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.BottomEnd
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    text = navDescription,
                    style = MaterialTheme.typography.bodyMedium,
                    color = ColorFadedBlack,
                    textAlign = TextAlign.Center
                )
                Text(
                    modifier = Modifier.clickable{ onNavScreenClicked() },
                    text = navTitle,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }
    }
}

@Composable
private fun LoginForgotPassword(
    onForgotPasswordClicked: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(0.8f),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            modifier = Modifier
                .clickable {
                    onForgotPasswordClicked()
                },
            text = stringResource(R.string.login_forgot_your_password),
            style = MaterialTheme.typography.bodyMedium,
            color = ColorFadedBlack,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
private fun FieldItem(
    field: FieldUiItem,
    modifier: Modifier = Modifier
) {
    TextField(
        modifier = modifier
            .fillMaxWidth(0.8f)
            .aspectRatio(5.7f),
        value = field.text.value,
        onValueChange = {
            field.onUpdateText(it)
        },
        label = {
            Text(
                text = stringResource(field.label),
                style = MaterialTheme.typography.labelMedium,
                color = ColorLoginBackground1
            )
        },
        isError = field.alreadyExists.value,
        textStyle = MaterialTheme.typography.titleSmall.copy(color = ColorFadedBlack),
        keyboardOptions = KeyboardOptions(
            keyboardType = field.keyboardType,
            imeAction = ImeAction.Done
        ),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            errorContainerColor = Color.White,
            disabledContainerColor = MaterialTheme.colorScheme.background,
            cursorColor = MaterialTheme.colorScheme.background,
            errorTextColor = Color.Red,
            errorCursorColor = Color.Black,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black,
            unfocusedIndicatorColor = Color.Black
        )
    )
}