package co.jassonkm.nimblechallenge.ui.screens.view

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import co.jassonkm.nimblechallenge.domain.model.SurveyItem
import co.jassonkm.nimblechallenge.ui.components.pages.HomePage
import co.jassonkm.nimblechallenge.ui.theme.GradientBrush

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    val surveyItems = listOf(
        SurveyItem(
            title = "Working from home Check-In 1",
            description = "We would like to know how you feel about our work from home...",
            coverImageUrl = ""
        ),
        SurveyItem(
            "Inclusion and belonging",
            "Building a workplace culture that prioritizes belonging and inclusio...",
            ""
        )
    )
    HomePage(
        date = "Monday, JUNE 15",
        onClickLogout = { /*TODO*/ },
        surveyItems = surveyItems,
        pagerState = rememberPagerState(),
        painterBrush = GradientBrush,
        onCLickNext = {navController.navigate("survey_detail_screen")},
    )
}