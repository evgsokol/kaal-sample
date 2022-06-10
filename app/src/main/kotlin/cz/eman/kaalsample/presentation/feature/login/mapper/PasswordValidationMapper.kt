package cz.eman.kaalsample.presentation.feature.login.mapper

import cz.eman.kaalsample.R
import cz.eman.kaalsample.domain.feature.usermanagement.model.PasswordValidation
import cz.eman.kaalsample.presentation.feature.login.states.PasswordValidationState


fun PasswordValidation.toPasswordState(): PasswordValidationState {
    return when (this) {
        is PasswordValidation.InvalidChar -> PasswordValidationState(R.string.invalid_char_error_text)
        is PasswordValidation.Empty -> PasswordValidationState(R.string.empty_error_text)
        is PasswordValidation.Easy -> PasswordValidationState(R.string.easy_error_text)
        is PasswordValidation.Short -> PasswordValidationState(R.string.short_error_text)
        is PasswordValidation.Medium -> PasswordValidationState(R.string.medium_error_text, false)
        is PasswordValidation.Strong -> PasswordValidationState(R.string.strong_approve_text, false)
    }
}