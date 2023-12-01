package co.jassonkm.nimblechallenge.ui.components.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import co.jassonkm.nimblechallenge.domain.model.SurveyItem
import co.jassonkm.nimblechallenge.ui.components.atoms.LoadImage
import co.jassonkm.nimblechallenge.ui.components.templates.SurveyDetailTemplate

@Composable
fun SurveyDetailPage(surveyItems: SurveyItem, onCLickStart: () -> Unit, onClickBack: () -> Unit) {
    val imageHd = surveyItems.coverImageUrl+"l"
    Box(modifier = Modifier.fillMaxSize()) {
        LoadImage(url = imageHd)
        SurveyDetailTemplate(
            title = surveyItems.title,
            description = surveyItems.description,
            onClickBack = onClickBack,
            onClickStart = onCLickStart
        )
    }

}
