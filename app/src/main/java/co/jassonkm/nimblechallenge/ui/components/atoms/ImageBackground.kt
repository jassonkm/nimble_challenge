package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@Composable
fun ImageBackground(image: Int) {
    Image(
        painter = painterResource(id = image),
        contentDescription = "background_image",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}