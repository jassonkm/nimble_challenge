package co.jassonkm.nimblechallenge.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("access_token")
    val token: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("expires_in")
    val timeExpires: Int
)
