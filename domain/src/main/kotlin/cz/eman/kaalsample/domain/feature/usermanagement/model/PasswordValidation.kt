package cz.eman.kaalsample.domain.feature.usermanagement.model

sealed class PasswordValidation {

    object InvalidChar : PasswordValidation()
    object Empty : PasswordValidation()
    object Short : PasswordValidation()
    object Easy : PasswordValidation()
    object Medium : PasswordValidation()
    object Strong : PasswordValidation()
}