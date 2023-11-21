package co.jassonkm.nimblechallenge.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import co.jassonkm.nimblechallenge.ui.navigation.AppNavigation
import co.jassonkm.nimblechallenge.ui.theme.NimbleChallengeTheme

@Composable
fun NimbleAppNav(navHostController: NavHostController) {
    NimbleChallengeTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            AppNavigation(navController = navHostController)
        }
    }
}