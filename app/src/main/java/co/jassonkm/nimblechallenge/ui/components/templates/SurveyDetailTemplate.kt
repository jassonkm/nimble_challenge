package co.jassonkm.nimblechallenge.ui.components.templates

import android.service.quicksettings.Tile
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.ui.components.organisms.SurveyDetailFooter
import co.jassonkm.nimblechallenge.ui.components.organisms.SurveyDetailHeader

@Composable
fun SurveyDetailTemplate(title: String, description: String, onClickBack: () -> Unit, onClickStart: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 35.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ){
        SurveyDetailHeader(titleDescription = title , description = description, onClickBack = onClickBack)
        SurveyDetailFooter (onClickStart = onClickStart)
    }
}
@Preview
@Composable
fun SurveyDetailTemplatePreview() {
    SurveyDetailTemplate(title = "Working from home Check-In", description = "We would like to know how you feel about our work from home (WFH) experience.", onClickBack = {}, onClickStart = {})
}