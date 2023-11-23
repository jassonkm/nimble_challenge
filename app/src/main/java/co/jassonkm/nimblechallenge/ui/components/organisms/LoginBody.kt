package co.jassonkm.nimblechallenge.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.ui.components.atoms.TextFieldEmail
import co.jassonkm.nimblechallenge.ui.components.atoms.TextFieldPassword
import co.jassonkm.nimblechallenge.ui.components.molecules.ButtonLogin

@Composable
fun LoginBody(
    email: String,
    password: String,
    onEmailChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onLoginClicked: () -> Unit,
    onForgotPassword: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextFieldEmail(email, onTextChanged = onEmailChanged)
        TextFieldPassword(
            password,
            onPasswordChanged = onPasswordChanged,
            onForgotPassword = onForgotPassword
        )
        ButtonLogin(onClick = onLoginClicked)
    }

}
