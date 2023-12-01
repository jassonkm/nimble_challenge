package co.jassonkm.nimblechallenge.data.remote.model.request

import com.google.gson.annotations.SerializedName

data class LogoutRequest(
    val token: String,
    @SerializedName("client_id")
    val clientId: String,
    @SerializedName("client_secret")
    val clientSecret: String
)
