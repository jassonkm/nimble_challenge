package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.rememberAsyncImagePainter
import coil.imageLoader
import coil.request.ImageRequest

@Composable
fun LoadImage(url: String) {
    val imageLoader = LocalContext.current.imageLoader
    val imageRequest = ImageRequest.Builder(LocalContext.current)
        .data(url)
        .crossfade(true)
        .build()
    val painter = rememberAsyncImagePainter(
        model = imageRequest,
        imageLoader = imageLoader
    )
    ImageBackground(painter = painter)

}

@Preview
@Composable
fun LoadImagePreview() {

    LoadImage(url = "https://dhdbhh0jsld0o.cloudfront.net/m/1ea51560991bcb7d00d0_l")

}