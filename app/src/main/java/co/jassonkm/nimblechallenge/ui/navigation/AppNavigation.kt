package co.jassonkm.nimblechallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import co.jassonkm.nimblechallenge.ui.screens.view.HomeScreen
import co.jassonkm.nimblechallenge.ui.screens.view.LoginScreen
import co.jassonkm.nimblechallenge.ui.screens.view.SplashScreen
import co.jassonkm.nimblechallenge.ui.screens.view.SurveyDetailScreen

@Composable
fun AppNavigation (navController: NavHostController) {
    NavHost(navController = navController, startDestination = "splash_screen" ){
        composable("splash_screen"){
            SplashScreen(navController = navController)
        }
        composable("login_screen"){
            LoginScreen(navController = navController)
        }
        composable("home_screen"){
            HomeScreen(navController = navController)
        }
        composable("survey_detail_screen"){
            SurveyDetailScreen(navController = navController)
        }
    }

}