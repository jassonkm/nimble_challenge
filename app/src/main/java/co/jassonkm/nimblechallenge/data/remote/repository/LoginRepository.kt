package co.jassonkm.nimblechallenge.data.remote.repository

import co.jassonkm.nimblechallenge.data.remote.model.request.LoginRequest
import co.jassonkm.nimblechallenge.data.remote.model.response.LoginResponse
import co.jassonkm.nimblechallenge.domain.model.User
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.flow.SharedFlow

interface LoginRepository {
    suspend fun login(user: User): ApiResponse<LoginResponse>
    fun refreshToken(): Boolean

    suspend fun logout()

    fun isTokenExpired(): Boolean

}