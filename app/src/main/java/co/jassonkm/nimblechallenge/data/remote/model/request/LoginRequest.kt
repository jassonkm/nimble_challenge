package co.jassonkm.nimblechallenge.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    @SerializedName("grant_type")
    val grantType: String = "password",
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("client_secret")
    val clientSecret: String
)
