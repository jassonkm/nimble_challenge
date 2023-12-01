package co.jassonkm.nimblechallenge.ui.screens.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import co.jassonkm.nimblechallenge.ui.components.pages.HomePage
import co.jassonkm.nimblechallenge.ui.screens.viewmodel.HomeViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel = hiltViewModel(), navController: NavController) {
    LaunchedEffect(Unit) {
        homeViewModel.getSurveys()
    }

    val pagerState = rememberPagerState()

    val isSurveyList by homeViewModel.surveyList.observeAsState()
    val isNotSessionActive by homeViewModel.isNotActiveSession.observeAsState()
    if (isNotSessionActive == true) {
        LaunchedEffect(Unit){
            navController.popBackStack()
        }
    }
    fun logout() {
        homeViewModel.logout()
    }

    if (isSurveyList == null) {
        CircularProgressIndicator()
    } else {
        HomePage(
            date = homeViewModel.getCurrentDateFormattedString(),
            onClickLogout = { logout() },
            surveyItems = isSurveyList!!,
            pagerState = pagerState,
            onCLickNext = { navController.navigate("survey_detail_screen") },
        )
    }


}

