package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.ui.theme.White

@Composable
fun ImageLogo(width: Int, height: Int, image: Int, padding: Int) {
    Icon(
        painter = painterResource(id = image),
        contentDescription = "nimble_logo",
        tint = White,
        modifier = Modifier
            .padding(padding.dp)
            .width(width.dp)
            .height(height.dp)
            .scale(1.0f)
    )
}