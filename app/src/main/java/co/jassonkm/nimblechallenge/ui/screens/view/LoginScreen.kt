package co.jassonkm.nimblechallenge.ui.screens.view

import android.util.Patterns
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import co.jassonkm.nimblechallenge.domain.model.User
import co.jassonkm.nimblechallenge.ui.components.pages.LoginPage
import co.jassonkm.nimblechallenge.ui.screens.viewmodel.LoginViewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = hiltViewModel(),navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val isLogin by loginViewModel.isLogin.observeAsState()
    val isError by loginViewModel.error.observeAsState()
    val isLoading by loginViewModel.isLoading.observeAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    if (isLoading == true) {
        CircularProgressIndicator()
    }

    if (isLogin == true) {
        navController.navigate("home_screen")
    }

    if (!isError.isNullOrEmpty()) {
        LaunchedEffect(Unit){
            snackbarHostState.showSnackbar(
                message = isError!!,
                duration = SnackbarDuration.Short
            )
        }
    }
    fun validateLogin() {
        if (email.isNotEmpty() && password.isNotEmpty()) {
             if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                 val user = User(email, password)
                 loginViewModel.onLogin(user)
             }
        }

    }

    LoginPage(
        email = email,
        password = password,
        onEmailChanged = { newEmail -> email = newEmail },
        onPasswordChanged = { newPassword -> password = newPassword },
        onLoginClicked = { validateLogin() },
        onForgotPassword = { /*TODO*/ },
        snackbarHostState = snackbarHostState)
}