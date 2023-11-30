package co.jassonkm.nimblechallenge.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class RefreshTokenRequest(
    @SerializedName("grant_type")
    val grantType: String = "refresh_token",
    @SerializedName("refresh_Token")
    val refreshToken: String,
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("client_secret")
    val clientSecret: String
)