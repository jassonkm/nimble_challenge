package co.jassonkm.nimblechallenge.data.remote.repository

import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyResponse
import com.skydoves.sandwich.ApiResponse

interface SurveyRepository {
    suspend fun getSurveyList(page: Int, pageSize: Int): ApiResponse<SurveyResponse>
    suspend fun getSurveyDetail(surveyId: Int): ApiResponse<SurveyResponse>
}