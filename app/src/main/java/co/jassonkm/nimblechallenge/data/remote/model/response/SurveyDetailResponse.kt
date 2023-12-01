package co.jassonkm.nimblechallenge.data.remote.model.response

import com.google.gson.annotations.SerializedName

data class SurveyDetailResponse(
    @SerializedName("data")
    val dataSurvey: DataSurvey
)
