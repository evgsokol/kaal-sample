package cz.eman.kaalsample.data.feature.password.validation.repository

import cz.eman.kaalsample.domain.feature.usermanagement.repository.PasswordValidationRepository

class PasswordValidationRepositoryImpl : PasswordValidationRepository {

    override fun getPasswordInvalidChars() = charArrayOf('^','<','>','/',' ')
}