package co.jassonkm.nimblechallenge.domain.usecases

import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyResponse
import co.jassonkm.nimblechallenge.data.remote.repository.SurveyRepository
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class SurveyListUseCase @Inject constructor(private val surveyRepository: SurveyRepository){
    suspend operator fun invoke(): ApiResponse<SurveyResponse> = surveyRepository.getSurveyList()
}