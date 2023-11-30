package co.jassonkm.nimblechallenge.domain.usecases

import co.jassonkm.nimblechallenge.data.remote.repository.LoginRepository
import javax.inject.Inject

class IsTokenActiveUseCase @Inject constructor(private val repository: LoginRepository) {
    operator fun invoke(): Boolean = repository.isTokenExpired()
}