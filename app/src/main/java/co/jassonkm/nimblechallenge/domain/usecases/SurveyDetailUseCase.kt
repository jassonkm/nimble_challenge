package co.jassonkm.nimblechallenge.domain.usecases

import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyDetailResponse
import co.jassonkm.nimblechallenge.data.remote.repository.SurveyRepository
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class SurveyDetailUseCase @Inject constructor(private val repository: SurveyRepository) {
    suspend operator fun invoke(surveyId: String): ApiResponse<SurveyDetailResponse> =
        repository.getSurveyDetail(surveyId)
}