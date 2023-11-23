package co.jassonkm.nimblechallenge.ui.components.molecules

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.jassonkm.nimblechallenge.ui.components.atoms.TextCommon
import co.jassonkm.nimblechallenge.ui.theme.White

@Composable
fun TextDescription(titleDescription: String, description: String) {
    Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
        TextCommon(
            text = titleDescription,
            modifier = Modifier
                .width(335.dp)
                .height(68.dp),
            style = TextStyle(
                fontSize = 28.sp,
                lineHeight = 34.sp,
                fontWeight = FontWeight.Bold,
                color = White,
            )
        )
        TextCommon(
            text = description,
            modifier = Modifier
                .width(259.dp)
                .height(42.dp),
            style = TextStyle(
                fontSize = 17.sp,
                lineHeight = 22.sp,
                fontWeight = FontWeight(300),
                color = White
            )
        )
    }
}
@Preview
@Composable
fun PreviewTextDescription() {
    TextDescription("Working from home Check-In", "We would like to know how you feel about our work from home...")
}