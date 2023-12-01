package co.jassonkm.nimblechallenge.ui.screens.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.jassonkm.nimblechallenge.domain.model.SurveyItem
import co.jassonkm.nimblechallenge.domain.usecases.SurveyDetailUseCase
import co.jassonkm.nimblechallenge.util.NetworkUtils
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurveyDetailViewModel @Inject constructor(
    private val surveyDetailUseCase: SurveyDetailUseCase,
    private val networkUtils: NetworkUtils,
) : ViewModel() {

    private val TAG = "SurveyDetailViewModel"
    private val _surveyDetail = MutableLiveData<SurveyItem>()
    val isSurveyDetail: MutableLiveData<SurveyItem>
        get() = _surveyDetail

    fun getSurveyDetail(surveyId: String) {
        if (networkUtils.isNetworkAvailable()) {
            try {
                viewModelScope.launch {
                    surveyDetailUseCase.invoke(surveyId)
                        .onSuccess {
                            val attributes = response.body()?.dataSurvey?.attributes
                            val surveyItem = SurveyItem(
                                title = attributes?.title!!,
                                description = attributes.description,
                                coverImageUrl = attributes.imageUrl
                            )
                            _surveyDetail.postValue(surveyItem)
                            Log.i(TAG, "getSurveyDetail: ")
                        }
                        .onError {
                            Log.e(TAG, "getSurveyDetailError: ${response.errorBody()}")
                        }
                        .onFailure {
                            Log.e(TAG, "getSurveyDetail: failure")
                        }
                }
            } catch (e: Exception) {
                Log.e(TAG, "getSurveyDetail: ", e)
            }
        }
    }
}