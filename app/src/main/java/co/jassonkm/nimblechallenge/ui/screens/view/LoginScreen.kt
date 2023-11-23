package co.jassonkm.nimblechallenge.ui.screens.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import co.jassonkm.nimblechallenge.ui.components.pages.LoginPage

@Composable
fun LoginScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    LoginPage(
        email = email,
        password = password,
        onEmailChanged = { newEmail -> email = newEmail },
        onPasswordChanged = { newPassword -> password = newPassword },
        onLoginClicked = { navController.navigate("home_screen") },
        onForgotPassword = { /*TODO*/ })
}