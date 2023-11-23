package co.jassonkm.nimblechallenge.ui.screens.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import co.jassonkm.nimblechallenge.data.SurveyItem
import co.jassonkm.nimblechallenge.ui.components.pages.SurveyDetailPage
import co.jassonkm.nimblechallenge.ui.theme.GradientBrush

@Composable
fun SurveyDetailScreen(navController: NavController) {
    val surveyItem = SurveyItem(
        title = "Working from home Check-In 1",
        description = "We would like to know how you feel about our work from home...",
        coverImageUrl = ""
    )
    SurveyDetailPage(
        surveyItems = surveyItem,
        onCLickStart = {},
        onClickBack = { navController.popBackStack() },
        painterBrush = GradientBrush
    )

}