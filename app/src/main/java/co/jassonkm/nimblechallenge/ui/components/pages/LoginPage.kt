package co.jassonkm.nimblechallenge.ui.components.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.jassonkm.nimblechallenge.ui.components.templates.LoginTemplate
import co.jassonkm.nimblechallenge.ui.theme.GradientBrush

@Composable
fun LoginPage(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onForgotPassword: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GradientBrush)
    ) {
        LoginTemplate(
            email = email,
            password = password,
            onEmailChanged = onEmailChanged,
            onPasswordChanged = onPasswordChanged,
            onLoginClicked = onLoginClicked,
            onForgotPassword = onForgotPassword
        )
    }
}
