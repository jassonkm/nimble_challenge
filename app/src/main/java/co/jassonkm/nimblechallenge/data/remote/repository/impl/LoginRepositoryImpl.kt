package co.jassonkm.nimblechallenge.data.remote.repository.impl

import co.jassonkm.nimblechallenge.BuildConfig
import co.jassonkm.nimblechallenge.data.remote.api.ApiServiceAuth
import co.jassonkm.nimblechallenge.data.remote.model.request.LoginRequest
import co.jassonkm.nimblechallenge.data.remote.model.request.LogoutRequest
import co.jassonkm.nimblechallenge.data.remote.model.request.RefreshTokenRequest
import co.jassonkm.nimblechallenge.data.remote.model.response.LoginResponse
import co.jassonkm.nimblechallenge.data.remote.repository.LoginRepository
import co.jassonkm.nimblechallenge.di.IoDispatcher
import co.jassonkm.nimblechallenge.domain.model.User
import co.jassonkm.nimblechallenge.util.TokenManager
import com.skydoves.sandwich.ApiResponse
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class LoginRepositoryImpl @Inject constructor(
    @Named("auth") private val apiServiceAuth: ApiServiceAuth,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
    private val tokenManager: TokenManager
) : LoginRepository {
    private val clientId = BuildConfig.CLIENT_ID
    private val clientSecret = BuildConfig.CLIENT_SECRET

    override suspend fun login(user: User): ApiResponse<LoginResponse> = withContext(ioDispatcher) {
        val loginRequest = LoginRequest(
            email = user.email,
            password = user.password,
            clientId = clientId,
            clientSecret = clientSecret
        )
        apiServiceAuth.login(loginRequest)
            .onSuccess {
                tokenManager.saveAccessToken(response.body()!!.data.attributes.token)
                tokenManager.saveRefreshToken(response.body()!!.data.attributes.refreshToken)
                tokenManager.saveTokenExpiryTime(response.body()!!.data.attributes.timeExpires)
            }
            .onError {
                tokenManager.clearToken()
            }
            .onFailure {
                tokenManager.clearToken()
            }

    }

    override fun refreshToken(): Boolean {
        var isRefreshToken = false
        val refreshTokenRequest = RefreshTokenRequest(
            clientSecret = clientSecret,
            clientId = clientId,
            refreshToken = tokenManager.getRefreshToken()
        )

        try {
            apiServiceAuth.refreshToken(refreshTokenRequest)
                .onSuccess {
                    tokenManager.saveAccessToken(response.body()!!.data.attributes.token)
                    tokenManager.saveRefreshToken(response.body()!!.data.attributes.refreshToken)
                    tokenManager.saveTokenExpiryTime(response.body()!!.data.attributes.timeExpires)
                    isRefreshToken = true
                }
                .onError {
                    isRefreshToken = false
                }
                .onFailure {
                    isRefreshToken = false
                }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return isRefreshToken
    }

    override suspend fun logout(): Unit = withContext(ioDispatcher) {
        val logoutRequest = LogoutRequest(
            token = tokenManager.getAccessToken(),
            clientId = clientId,
            clientSecret = clientSecret
        )
        apiServiceAuth.logout(logoutRequest)
            .onSuccess {
                tokenManager.clearToken()
            }
    }

    override fun isTokenExpired(): Boolean {
        return tokenManager.hasTokenExpired()
    }


}