package co.jassonkm.nimblechallenge.data.remote.api

import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyDetail
import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyDetailResponse
import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyResponse
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceSurvey {
    @GET("surveys")
    suspend fun getSurveyList(
        @Query("page[number]") pageNumber: Int,
        @Query("page[size]") pageSize: Int
    ): ApiResponse<SurveyResponse>

    @GET("surveys/{survey_id}")
    suspend fun getSurveyDetail(
        @Path("survey_id") surveyId: String
    ): ApiResponse<SurveyDetailResponse>

}