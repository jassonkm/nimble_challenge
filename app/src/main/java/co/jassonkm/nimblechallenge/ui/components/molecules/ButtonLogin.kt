package co.jassonkm.nimblechallenge.ui.components.molecules

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.jassonkm.nimblechallenge.ui.components.atoms.ButtonCommon
import co.jassonkm.nimblechallenge.ui.theme.Black
import co.jassonkm.nimblechallenge.ui.theme.White

@Composable
fun ButtonLogin(onClick: () -> Unit) {
    ButtonCommon(
        onClick = onClick, text = "Log in", color = White, myStyle = TextStyle(
            fontSize = 17.sp,
            lineHeight = 22.sp,
            fontWeight = FontWeight(800),
            color = Black,
            textAlign = TextAlign.Center
        ),
        modifier = Modifier
            .padding(0.dp)
            .width(330.dp)
            .height(58.dp)
    )
}
@Preview
@Composable
fun PreviewButtonLogin() {
    ButtonLogin(onClick = {})
}