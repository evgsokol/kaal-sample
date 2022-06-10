package cz.eman.kaalsample.presentation.feature.login.di

import cz.eman.kaalsample.data.feature.password.validation.repository.PasswordValidationRepositoryImpl
import cz.eman.kaalsample.domain.feature.usermanagement.repository.PasswordValidationRepository
import cz.eman.kaalsample.domain.feature.usermanagement.usecase.CheckPasswordValidationUseCase
import cz.eman.kaalsample.presentation.feature.login.viewModel.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 *  @author stefan.toth@eman.cz
 */
val loginModule = module {

    viewModel {
        LoginViewModel(
            authoriseUser = get(),
            registerUser = get(),
            checkPasswordValidation = get()
        )
    }

    single<PasswordValidationRepository> { PasswordValidationRepositoryImpl() }
    factory { CheckPasswordValidationUseCase(repository = get()) }

}