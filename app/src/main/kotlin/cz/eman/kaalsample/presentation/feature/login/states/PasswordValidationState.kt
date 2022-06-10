package cz.eman.kaalsample.presentation.feature.login.states

import androidx.annotation.StringRes

data class PasswordValidationState(
    @StringRes val errorTextId: Int,
    val isErrorTextEnabled: Boolean = true
)