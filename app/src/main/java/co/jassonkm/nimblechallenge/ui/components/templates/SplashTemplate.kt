package co.jassonkm.nimblechallenge.ui.components.templates

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import co.jassonkm.nimblechallenge.ui.components.molecules.ImageSplashLogo
import co.jassonkm.nimblechallenge.ui.theme.White

@Composable
fun SplashTemplate() {
    Column(

        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ImageSplashLogo()
    }
}
@Preview
@Composable
fun PreviewSplashTemplate() {
    SplashTemplate()
}