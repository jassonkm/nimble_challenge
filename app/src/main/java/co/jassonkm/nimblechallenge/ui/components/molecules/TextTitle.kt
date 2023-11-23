package co.jassonkm.nimblechallenge.ui.components.molecules

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
fun TextTitle(title: String, date: String) {
    Column {
        TextCommon(
            text = date,
            modifier = Modifier
                .width(117.dp)
                .height(18.dp),
            style = TextStyle(
                fontSize = 13.sp,
                lineHeight = 18.sp,
                fontWeight = FontWeight.Bold,
                color = White,
            )
        )
        TextCommon(
            text = title,
            modifier = Modifier
                .width(97.dp)
                .height(41.dp),
            style = TextStyle(
                fontSize = 34.sp,
                lineHeight = 41.sp,
                fontWeight = FontWeight.Bold,
                color = White
            )
        )
    }
}
@Preview
@Composable
fun PreviewTextTitle() {
    TextTitle(title = "Today", date = "Monday, JUNE 15")
}