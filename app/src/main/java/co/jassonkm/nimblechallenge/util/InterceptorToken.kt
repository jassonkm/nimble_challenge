package co.jassonkm.nimblechallenge.util

import co.jassonkm.nimblechallenge.domain.usecases.IsTokenActiveUseCase
import co.jassonkm.nimblechallenge.domain.usecases.RefreshTokenUseCase
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InterceptorToken @Inject constructor(
    private val tokenManager: TokenManager,
    private val isTokenActiveUseCase: IsTokenActiveUseCase,
    private val refreshTokenUseCase: RefreshTokenUseCase
) : Interceptor {
    private lateinit var token: String

    @Synchronized
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!isTokenActiveUseCase.invoke()) {
            refreshTokenUseCase.invoke()
        }
        token = tokenManager.getAccessToken()
        if (request.header("Authorization") == null && token.isNotEmpty()) {
            request = request.newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
        }
        return chain.proceed(request)
    }

}