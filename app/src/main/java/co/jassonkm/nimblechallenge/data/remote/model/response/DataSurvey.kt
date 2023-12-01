package co.jassonkm.nimblechallenge.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class DataSurvey(
    val id: String,
    val type: String,
    @SerializedName("attributes")
    val attributes: SurveyDetail
)
