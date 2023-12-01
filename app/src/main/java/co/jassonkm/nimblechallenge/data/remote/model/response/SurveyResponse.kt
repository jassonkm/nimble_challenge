package co.jassonkm.nimblechallenge.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class SurveyResponse(
    @SerializedName("data")
    val data: List<DataSurvey>
)