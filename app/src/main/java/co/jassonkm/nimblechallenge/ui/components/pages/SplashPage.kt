package co.jassonkm.nimblechallenge.ui.components.pages

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.jassonkm.nimblechallenge.ui.components.molecules.ImageBackgroundSplash
import co.jassonkm.nimblechallenge.ui.components.templates.SplashTemplate

@Composable
fun SplashPage() {
    Box(modifier = Modifier.fillMaxSize())  {
        ImageBackgroundSplash()
        SplashTemplate()
    }
}
@Preview
@Composable
fun PreviewSplashPage() {
    SplashPage()
}