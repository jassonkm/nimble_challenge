package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.ui.theme.White

@Composable
fun ButtonCommon(onClick: () -> Unit, text: String, color: Color, myStyle: TextStyle, modifier: Modifier) {
    ElevatedButton(
        onClick = onClick, colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = color
        ), modifier = modifier
    ) {
        Text(
            text = text, style = myStyle
        )
    }
}