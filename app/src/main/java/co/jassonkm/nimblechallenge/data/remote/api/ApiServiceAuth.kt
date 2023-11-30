package co.jassonkm.nimblechallenge.data.remote.api

import co.jassonkm.nimblechallenge.data.remote.model.request.LoginRequest
import co.jassonkm.nimblechallenge.data.remote.model.request.LogoutRequest
import co.jassonkm.nimblechallenge.data.remote.model.request.RefreshTokenRequest
import co.jassonkm.nimblechallenge.data.remote.model.response.LoginResponse
import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyDetailResponse
import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceAuth {
    @POST("oauth/token")
    suspend fun login(@Body loginRequest: LoginRequest): ApiResponse<LoginResponse>
    @POST("oauth/token")
    fun refreshToken(@Body refreshTokenRequest: RefreshTokenRequest): ApiResponse<LoginResponse>
    @POST("oauth/revoke")
    suspend fun logout(logoutRequest: LogoutRequest): ApiResponse<Unit>


}
