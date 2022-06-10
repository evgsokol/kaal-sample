package cz.eman.kaalsample.domain.feature.usermanagement.repository

import cz.eman.kaalsample.domain.feature.usermanagement.model.InvalidCharacters

interface PasswordValidationRepository {

    fun getPasswordInvalidChars(): InvalidCharacters
}