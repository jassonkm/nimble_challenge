package co.jassonkm.nimblechallenge.domain.usecases

import co.jassonkm.nimblechallenge.data.remote.model.response.LoginResponse
import co.jassonkm.nimblechallenge.data.remote.repository.LoginRepository
import co.jassonkm.nimblechallenge.domain.model.User
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: LoginRepository) {
    suspend operator fun invoke(user: User): ApiResponse<LoginResponse> = repository.login(user)
}