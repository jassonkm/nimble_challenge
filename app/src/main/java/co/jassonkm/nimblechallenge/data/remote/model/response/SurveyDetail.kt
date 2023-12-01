package co.jassonkm.nimblechallenge.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class SurveyDetail(
    val id: String,
    val title: String,
    val description: String,
    @SerializedName("cover_image_url")
    val imageUrl: String,
    @SerializedName("is_active")
    val isActive: Boolean
)
