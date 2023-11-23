package co.jassonkm.nimblechallenge.ui.components.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import co.jassonkm.nimblechallenge.data.SurveyItem
import co.jassonkm.nimblechallenge.ui.components.templates.SurveyDetailTemplate

@Composable
fun SurveyDetailPage(surveyItems: SurveyItem, onCLickStart: () -> Unit, onClickBack: () -> Unit, painterBrush: Brush,) {
    Box(modifier = Modifier.fillMaxSize().background(brush = painterBrush)) {
        SurveyDetailTemplate(
            title = surveyItems.title,
            description = surveyItems.description,
            onClickBack = onClickBack,
            onClickStart = onCLickStart
        )
    }

}
