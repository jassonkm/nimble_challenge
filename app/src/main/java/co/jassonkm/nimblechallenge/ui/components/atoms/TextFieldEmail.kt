package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.jassonkm.nimblechallenge.ui.theme.BlackGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldEmail(email: String, onTextChanged: (String) -> Unit) {
    OutlinedTextField(
        value = email,
        onValueChange = onTextChanged,
        modifier = Modifier
            .width(330.dp)
            .height(58.dp),
        textStyle = TextStyle(
            fontSize = 14.sp,
            color = BlackGrey,
            fontWeight = FontWeight(400)
        ), singleLine = true,
        placeholder = { Text(text = "Email") },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Email
        )
    )

}
