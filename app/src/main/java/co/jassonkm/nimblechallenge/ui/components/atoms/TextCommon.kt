package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle

@Composable
fun TextCommon(text: String, modifier: Modifier, style: TextStyle) {
    Text(text = text, modifier = modifier, style = style)
}