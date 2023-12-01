package co.jassonkm.nimblechallenge.domain.usecases

import co.jassonkm.nimblechallenge.data.remote.repository.LoginRepository
import javax.inject.Inject

class LogoutUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke()= repository.logout()
}