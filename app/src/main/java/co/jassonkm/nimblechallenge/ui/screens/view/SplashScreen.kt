package co.jassonkm.nimblechallenge.ui.screens.view

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavController
import co.jassonkm.nimblechallenge.ui.components.pages.SplashPage
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    SplashPage()
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate("login_screen")
    }
}