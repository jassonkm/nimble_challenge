package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.jassonkm.nimblechallenge.ui.theme.BlackGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldPassword(
    password: String,
    onPasswordChanged: (String) -> Unit,
    onForgotPassword: () -> Unit
) {

    OutlinedTextField(
        value = password,
        onValueChange = onPasswordChanged,
        modifier = Modifier
            .width(330.dp)
            .height(58.dp),
        textStyle = TextStyle(
            fontSize = 14.sp,
            color = BlackGrey,
            fontWeight = FontWeight(400)
        ), singleLine = true,
        placeholder = { Text(text = "Password") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        visualTransformation = PasswordVisualTransformation(),
        trailingIcon = {
            TextButton(onClick = onForgotPassword) {
                Text(
                    text = "Forgot?",
                    color = BlackGrey
                )
            }
        }
    )
}
