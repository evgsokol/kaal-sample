package cz.eman.kaalsample.domain.feature.usermanagement.usecase

import cz.eman.kaal.domain.usecases.UseCase
import cz.eman.kaalsample.domain.feature.usermanagement.model.InputPassword
import cz.eman.kaalsample.domain.feature.usermanagement.model.PasswordValidation
import cz.eman.kaalsample.domain.feature.usermanagement.repository.PasswordValidationRepository

class CheckPasswordValidationUseCase(
    private val repository: PasswordValidationRepository,
) : UseCase<PasswordValidation, InputPassword>() {

    override suspend fun doWork(params: InputPassword): PasswordValidation {
        val invalidChars = repository.getPasswordInvalidChars()
        return when {
            invalidChars.any { it in params } -> PasswordValidation.InvalidChar
            params.isEmpty() -> PasswordValidation.Empty
            params.length < 3 -> PasswordValidation.Short
            params.length < 5 -> PasswordValidation.Easy
            params.length == 5 -> PasswordValidation.Medium
            else -> PasswordValidation.Strong
        }
    }
}