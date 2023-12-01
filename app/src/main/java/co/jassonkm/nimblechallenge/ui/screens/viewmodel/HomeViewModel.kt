package co.jassonkm.nimblechallenge.ui.screens.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.jassonkm.nimblechallenge.data.remote.model.response.DataSurvey
import co.jassonkm.nimblechallenge.domain.usecases.IsTokenActiveUseCase
import co.jassonkm.nimblechallenge.domain.usecases.LogoutUseCase
import co.jassonkm.nimblechallenge.domain.usecases.SurveyListUseCase
import co.jassonkm.nimblechallenge.util.NetworkUtils
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val surveyListUseCase: SurveyListUseCase,
    private val networkUtils: NetworkUtils,
    private val isTokenActiveUseCase: IsTokenActiveUseCase,
    private val logoutUseCase: LogoutUseCase
) : ViewModel() {

    private val TAG = "HomeViewModel"
    private val _surveyList = MutableLiveData<List<DataSurvey>>()
    val surveyList: MutableLiveData<List<DataSurvey>>
        get() = _surveyList
    private val _isLogot = MutableLiveData(false)
    val isNotActiveSession: MutableLiveData<Boolean>
        get() = _isLogot

    fun getSurveys() {
        if (networkUtils.isNetworkAvailable()) {
            if (isTokenActiveUseCase.invoke()) {
                _isLogot.postValue(false)
                try {
                    viewModelScope.launch {
                        surveyListUseCase.invoke()
                            .onSuccess {
                                _surveyList.postValue(response.body()?.data)
                                Log.i(TAG, "getSurveys: ")
                            }
                            .onError {
                                Log.e(TAG, "getSurveys: ${response.errorBody()}")
                            }
                            .onFailure {
                                Log.e(TAG, "getSurveys: failure")
                            }
                    }
                } catch (e: Exception) {
                    Log.e(TAG, "getSurveys: ", e)
                }
            }
            else
                _isLogot.postValue(true)
        }
    }
    fun logout() {
        if (networkUtils.isNetworkAvailable()) {

            try {
                if (!isTokenActiveUseCase.invoke())
                    _isLogot.postValue(true)
                viewModelScope.launch {
                    logoutUseCase.invoke()
                    _isLogot.postValue(true)
                }
            } catch (e: Exception) {
                _isLogot.postValue(false)
                Log.e(TAG, "getSurveys: ", e)
            }


        }
    }
    fun getCurrentDateFormattedString(): String {
        val calendar = Calendar.getInstance()
        val dateFormat = SimpleDateFormat("EEEE, MMMM d", Locale.ENGLISH)
        return dateFormat.format(calendar.time).uppercase()
    }

}