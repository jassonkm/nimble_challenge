package co.jassonkm.nimblechallenge.data.remote.repository

import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyDetailResponse
import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyResponse
import com.skydoves.sandwich.ApiResponse

interface SurveyRepository {
    suspend fun getSurveyList(): ApiResponse<SurveyResponse>
    suspend fun getSurveyDetail(surveyId: String): ApiResponse<SurveyDetailResponse>
}