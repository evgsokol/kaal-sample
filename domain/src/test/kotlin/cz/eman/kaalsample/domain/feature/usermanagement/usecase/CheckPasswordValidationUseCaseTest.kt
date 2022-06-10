package cz.eman.kaalsample.domain.feature.usermanagement.usecase


import cz.eman.kaalsample.domain.feature.usermanagement.model.InvalidCharacters
import cz.eman.kaalsample.domain.feature.usermanagement.model.PasswordValidation
import cz.eman.kaalsample.domain.feature.usermanagement.repository.PasswordValidationRepository
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import io.mockk.coEvery
import io.mockk.mockk

internal class CheckPasswordValidationUseCaseTest : StringSpec() {

    private val invalidPasswordList = listOf(
        "qwertyu^",
        "qwer<tyu",
        "qw>ertyu",
        "qwe/rtyu",
        "qw ertyu"
    )

    private val invalidChars: InvalidCharacters = charArrayOf('^', '<', '>', '/', ' ')

    private val repositoryMock: PasswordValidationRepository = mockk {
        coEvery { getPasswordInvalidChars() } returns invalidChars
    }

    val testedUseCase = CheckPasswordValidationUseCase(repositoryMock)

    init {

        "password contains invalid chars" {
            for (password in invalidPasswordList) {
                testedUseCase(password) shouldBe PasswordValidation.InvalidChar
            }
        }

        "password should not be empty" {
            testedUseCase("") shouldBe PasswordValidation.Empty
        }

        "password should not be too short"{
            testedUseCase("qw") shouldBe PasswordValidation.Short
        }

        "password should not be too easy" {
            testedUseCase("qwer") shouldBe PasswordValidation.Easy
        }

        "password strength is rather good"{
            testedUseCase("qwert") shouldBe PasswordValidation.Medium
        }

        "password strength is very good"{
            testedUseCase("q43we1rtVy") shouldBe PasswordValidation.Strong
        }

    }
}