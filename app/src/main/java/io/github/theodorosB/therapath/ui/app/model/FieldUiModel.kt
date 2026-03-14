package io.github.theodorosB.therapath.ui.app.model

import androidx.annotation.StringRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.KeyboardType
import io.github.theodorosB.therapath.R
import io.github.theodorosB.therapath.ui.util.ext.hasSpecialCharacter
import io.github.theodorosB.therapath.ui.util.ext.isValidEmail

sealed class FieldUiItem(
    @StringRes val label: Int = R.string.empty_string,
    @StringRes val title: Int = R.string.empty_string,
    val keyboardType: KeyboardType,
    val text: MutableState<String> = mutableStateOf(""),
    val isTextHidden: MutableState<Boolean> = mutableStateOf(false),
    val alreadyExists: MutableState<Boolean> = mutableStateOf(false),
    val validationRules: List<ValidationRule> = emptyList()
) {

    val isValid: Boolean
        get() = validationRules.all { it.isValid.value }

    fun onUpdateText(updatedText: String) {
        text.value = updatedText

        validationRules.forEach { rule ->
            rule.isValid(updatedText)
        }
    }

    fun toggleTextVisibility() {
        isTextHidden.value = !isTextHidden.value
    }

    class Email: FieldUiItem(
        label = R.string.sign_up_email_label,
        keyboardType = KeyboardType.Email,
        validationRules = listOf(
            ValidationRule.EmailRule(),
            ValidationRule.IsNotEmptyRule()
        )
    )

    class Username: FieldUiItem(
        label = R.string.sign_up_username_label,
        keyboardType = KeyboardType.Text,
        validationRules = listOf(
            ValidationRule.IsNotEmptyRule()
        )
    )

    class Password: FieldUiItem(
        label = R.string.sign_up_password_label,
        keyboardType = KeyboardType.Password,
        title = R.string.validation_rule_password_title,
        isTextHidden = mutableStateOf(true),
        validationRules = listOf(
            ValidationRule.IsNotEmptyRule(),
            ValidationRule.LengthRule(length = 8),
            ValidationRule.LowerCaseRule(),
            ValidationRule.UpperCaseRule(),
            ValidationRule.SpecialCharRule()
        )
    )

    class ConfirmPassword: FieldUiItem(
        label = R.string.sign_up_confirm_password_label,
        keyboardType = KeyboardType.Password,
        validationRules = listOf(
            ValidationRule.IsNotEmptyRule(),
            ValidationRule.LengthRule(length = 8),
            ValidationRule.LowerCaseRule(),
            ValidationRule.UpperCaseRule(),
            ValidationRule.SpecialCharRule()
        )
    )
}

sealed class ValidationRule(
    @StringRes val errorMessage: Int = R.string.empty_string,
    val isValid: MutableState<Boolean> = mutableStateOf(false)
) {

    abstract fun isValid(text: String)

    class IsNotEmptyRule: ValidationRule() {
        override fun isValid(text: String) {
            isValid.value = text.isNotBlank()
        }
    }

    class EmailRule: ValidationRule(
        errorMessage = R.string.validation_rule_invalid_email
    ) {
        override fun isValid(text: String) {
            isValid.value = text.isValidEmail()
        }
    }

    class LengthRule(
        val length: Int
    ): ValidationRule(
        errorMessage = R.string.validation_rule_password_length
    ) {
        override fun isValid(text: String) {
            isValid.value = text.length >= length
        }
    }

    class LowerCaseRule: ValidationRule(
        errorMessage = R.string.validation_rule_password_lowercase_letter
    ) {
        override fun isValid(text: String) {
            isValid.value = text.any { it.isLowerCase() }
        }
    }

    class UpperCaseRule: ValidationRule(
        errorMessage = R.string.validation_rule_password_uppercase_letter
    ) {
        override fun isValid(text: String) {
            isValid.value = text.any { it.isUpperCase() }
        }
    }

    class SpecialCharRule: ValidationRule(
        errorMessage = R.string.validation_rule_password_special_letter
    ) {
        override fun isValid(text: String) {
            isValid.value = text.hasSpecialCharacter()
        }
    }
}