package co.jassonkm.nimblechallenge.ui.screens.view

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import co.jassonkm.nimblechallenge.ui.components.pages.SurveyDetailPage
import co.jassonkm.nimblechallenge.ui.screens.viewmodel.SurveyDetailViewModel

@Composable
fun SurveyDetailScreen(
    surveyDetailViewModel: SurveyDetailViewModel = hiltViewModel(),
    navController: NavController,
    surveyId: String?
) {
    surveyDetailViewModel.getSurveyDetail(surveyId!!)
    val isSurveyDetail by surveyDetailViewModel.isSurveyDetail.observeAsState()
    if (isSurveyDetail == null) {
        CircularProgressIndicator()
    } else {
        SurveyDetailPage(
            surveyItems = isSurveyDetail!!,
            onCLickStart = {},
            onClickBack = { navController.popBackStack() },
        )
    }


}