package co.jassonkm.nimblechallenge.ui.screens.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.jassonkm.nimblechallenge.domain.model.User
import co.jassonkm.nimblechallenge.domain.usecases.LoginUseCase
import co.jassonkm.nimblechallenge.util.NetworkUtils
import com.skydoves.sandwich.onError
import com.skydoves.sandwich.onFailure
import com.skydoves.sandwich.onSuccess
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val networkUtils: NetworkUtils
) : ViewModel() {


    private val TAG = "LoginViewModel"

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: MutableLiveData<Boolean>
        get() = _isLoading

    private val _isLogin = MutableLiveData<Boolean>()
    val isLogin: MutableLiveData<Boolean>
        get() = _isLogin
    val error: LiveData<String>
        get() = _error
    private val _error = MutableLiveData<String>()


    fun onLogin(
        user: User
    ) {
        try {
            viewModelScope.launch {
                _isLoading.postValue(true)
                if (networkUtils.isNetworkAvailable()) {
                    loginUseCase.invoke(user)
                        .onSuccess {
                            _isLoading.postValue(false)
                            Log.i(TAG, "onLogin: Login completed")
                            _isLogin.postValue(true)
                        }
                        .onError {
                            _isLoading.postValue(false)
                            Log.e(TAG, "onLogin: error log  ${response.errorBody()}")
                            _isLogin.postValue(false)
                            _error.postValue(response.errorBody()?.string())
                        }
                        .onFailure {
                            _isLoading.postValue(false)
                            _isLogin.postValue(false)
                            _error.postValue("Email or password is incorrect")
                        }
                } else {
                    _isLoading.postValue(false)
                    _isLogin.postValue(false)
                    _error.postValue("No internet connection")
                }

            }
        } catch (e: Exception) {
            _isLoading.postValue(false)
            _isLogin.postValue(false)
            _error.postValue(e.message)
        }

    }
}