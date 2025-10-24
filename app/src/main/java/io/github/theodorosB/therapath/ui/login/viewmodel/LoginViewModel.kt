package io.github.theodorosB.therapath.ui.login.viewmodel

import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.theodorosB.therapath.R
import io.github.theodorosB.therapath.ui.app.model.FieldUiItem
import io.github.theodorosB.therapath.ui.base.BaseViewModel
import io.github.theodorosB.therapath.ui.login.model.LoginNavEntry
import io.github.theodorosB.therapath.ui.login.model.LoginUiState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import kotlin.properties.Delegates

@HiltViewModel
class LoginViewModel @Inject constructor(
) : BaseViewModel() {

    private val _uiState = MutableStateFlow(
        LoginUiState(
            onSubmitClicked = { onSubmitClicked() },
            onNavigateBackClicked = { onNavigateBackClicked() },
            onNavigateToSignInScreen = { navigateToSignIn() },
            onNavigateToSignUpScreen = { navigateToSignUp() },
            onNavScreenClicked = { onNavScreenClicked() },
            onNavigateToResetPasswordScreen = { navigateToResetPassword() }
        )
    )

    val uiState = _uiState.asStateFlow()

    var updateLoginStatus by Delegates.observable(_uiState.value.loginBackStack.lastOrNull()) { property, oldValue, newValue ->
        when (newValue) {
            is LoginNavEntry.SignIn -> {
                initSignInScreen()
            }

            is LoginNavEntry.SignUp -> {
                initSignUpScreen()
            }

            is LoginNavEntry.ResetPassword -> {
                initResetPasswordScreen()
            }

            else -> {}
        }
    }

    init {
        updateLoginStatus = LoginNavEntry.SignIn
    }

    private fun onSubmitClicked() {
        val currentScreen = _uiState.value.loginBackStack.lastOrNull()
        when (currentScreen) {
            is LoginNavEntry.SignIn -> {

            }

            is LoginNavEntry.SignUp -> {

            }

            is LoginNavEntry.ResetPassword -> {

            }

            else -> {}
        }
    }

    private fun onNavScreenClicked() {
        val currentScreen = _uiState.value.loginBackStack.lastOrNull()
        when (currentScreen) {
            is LoginNavEntry.SignIn -> {
                _uiState.value.loginBackStack.add(LoginNavEntry.SignUp)
            }

            is LoginNavEntry.SignUp -> {
                _uiState.value.loginBackStack.add(LoginNavEntry.SignIn)
            }

            is LoginNavEntry.ResetPassword -> {
                _uiState.value.loginBackStack.add(LoginNavEntry.SignIn)
            }
            else -> {}
        }
        updateLoginStatus = _uiState.value.loginBackStack.lastOrNull()
    }

    private fun onNavigateBackClicked() {
        val targetScreen = _uiState.value.loginBackStack.takeLast(2).firstOrNull()
        updateLoginStatus = targetScreen
        _uiState.value.loginBackStack.removeLastOrNull()
    }

    private fun navigateToSignIn() {
        val targetScreen = LoginNavEntry.SignIn
        _uiState.value.loginBackStack.add(targetScreen)
        updateLoginStatus = targetScreen
    }

    private fun navigateToSignUp() {
        val targetScreen = LoginNavEntry.SignUp
        _uiState.value.loginBackStack.add(targetScreen)
        updateLoginStatus = targetScreen
    }

    private fun navigateToResetPassword() {
        val targetScreen = LoginNavEntry.ResetPassword
        _uiState.value.loginBackStack.add(targetScreen)
        updateLoginStatus = targetScreen
    }

    private fun resetFields() {
        _uiState.value.fields.clear()
    }

    private fun initSignInScreen() {
        launch {
            delay(100)
            resetFields()
            val fields = listOf(
                FieldUiItem.Username(),
                FieldUiItem.Password()
            )
            _uiState.value.title.value = R.string.login_welcome_title
            _uiState.value.fields.addAll(elements = fields)
        }
    }

    private fun initSignUpScreen() {
        launch {
            delay(100)
            resetFields()
            val fields = listOf(
                FieldUiItem.Username(),
                FieldUiItem.Email(),
                FieldUiItem.Password()
            )
            _uiState.value.title.value = R.string.sign_up_title
            _uiState.value.fields.addAll(elements = fields)
        }
    }

    private fun initResetPasswordScreen() {
        launch {
            delay(100)
            resetFields()
            val fields = listOf(
                FieldUiItem.Email()
            )
            _uiState.value.title.value = R.string.login_reset_password_title
            _uiState.value.fields.addAll(elements = fields)
        }
    }
}