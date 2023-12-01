package co.jassonkm.nimblechallenge.data.remote.api

import co.jassonkm.nimblechallenge.data.remote.model.request.LoginRequest
import co.jassonkm.nimblechallenge.data.remote.model.request.LogoutRequest
import co.jassonkm.nimblechallenge.data.remote.model.request.RefreshTokenRequest
import co.jassonkm.nimblechallenge.data.remote.model.response.LoginResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiServiceAuth {
    @POST("oauth/token")
    suspend fun login(@Body loginRequest: LoginRequest): ApiResponse<LoginResponse>
    @POST("oauth/token")
    fun refreshToken(@Body refreshTokenRequest: RefreshTokenRequest): ApiResponse<LoginResponse>
    @POST("oauth/revoke")
    suspend fun logout(@Body logoutRequest: LogoutRequest): ApiResponse<Unit>


}
