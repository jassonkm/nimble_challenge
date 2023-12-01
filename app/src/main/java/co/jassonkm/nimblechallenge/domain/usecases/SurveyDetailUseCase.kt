package co.jassonkm.nimblechallenge.domain.usecases

import co.jassonkm.nimblechallenge.data.remote.repository.SurveyRepository
import javax.inject.Inject

class SurveyDetailUseCase @Inject constructor(private val repository: SurveyRepository) {
    suspend operator fun invoke(surveyId: String) = repository.getSurveyDetail(surveyId)
}