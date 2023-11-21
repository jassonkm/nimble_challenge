package co.jassonkm.nimblechallenge.ui.components.molecules

import androidx.compose.runtime.Composable
import co.jassonkm.nimblechallenge.R
import co.jassonkm.nimblechallenge.ui.components.atoms.ImageLogo

@Composable
fun ImageSplashLogo() {
    ImageLogo(
        image = R.drawable.nimble_logo,
        width = 200,
        height = 48,
        padding = 1
    )
}