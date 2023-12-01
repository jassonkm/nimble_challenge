package co.jassonkm.nimblechallenge.ui.components.molecules

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import co.jassonkm.nimblechallenge.R
import co.jassonkm.nimblechallenge.ui.components.atoms.ImageBackground

@Composable
fun ImageBackgroundSplash() {
     ImageBackground(painter = painterResource(id = R.drawable.splash) )
}