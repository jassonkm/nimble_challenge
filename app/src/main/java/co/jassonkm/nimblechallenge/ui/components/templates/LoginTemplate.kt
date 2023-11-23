package co.jassonkm.nimblechallenge.ui.components.templates

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.R
import co.jassonkm.nimblechallenge.ui.components.atoms.ImageLogo
import co.jassonkm.nimblechallenge.ui.components.organisms.LoginBody

@Composable
fun LoginTemplate(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onForgotPassword: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(1.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(110.dp)
    ) {
        Spacer(modifier = Modifier.height(50.dp))
        ImageLogo(width = 168, height = 40, image = R.drawable.nimble_logo, padding = 1)
        LoginBody(
            onEmailChanged = onEmailChanged,
            onPasswordChanged = onPasswordChanged,
            onLoginClicked = onLoginClicked,
            onForgotPassword = onForgotPassword,
            email = email,
            password = password
        )


    }
}
