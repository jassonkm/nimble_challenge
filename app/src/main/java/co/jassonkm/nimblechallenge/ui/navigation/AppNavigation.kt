package co.jassonkm.nimblechallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.jassonkm.nimblechallenge.ui.screens.view.LoginScreen
import co.jassonkm.nimblechallenge.ui.screens.view.SplashScreen

@Composable
fun AppNavigation (navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash_screen" ){
        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        composable("login_screen"){
            LoginScreen(navController = navController)
        }
    }

}