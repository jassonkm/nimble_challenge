package co.jassonkm.nimblechallenge.data.remote.repository.impl

import co.jassonkm.nimblechallenge.data.remote.api.ApiServiceSurvey
import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyDetailResponse
import co.jassonkm.nimblechallenge.data.remote.model.response.SurveyResponse
import co.jassonkm.nimblechallenge.data.remote.repository.SurveyRepository
import co.jassonkm.nimblechallenge.di.IoDispatcher
import com.skydoves.sandwich.ApiResponse
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Named

class SurveyRepositoryImpl @Inject constructor(
    @Named("survey") private val apiServiceSurvey: ApiServiceSurvey,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher
) : SurveyRepository {
    private val pageDefault = 1
    private val pageSizeDefault = 3
    override suspend fun getSurveyList(): ApiResponse<SurveyResponse> = withContext(ioDispatcher){
       apiServiceSurvey.getSurveyList(pageDefault, pageSizeDefault)
    }

    override suspend fun getSurveyDetail(surveyId: String): ApiResponse<SurveyDetailResponse> = withContext(ioDispatcher){
        apiServiceSurvey.getSurveyDetail(surveyId)
    }

}
