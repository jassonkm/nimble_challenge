package co.jassonkm.nimblechallenge.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.R
import co.jassonkm.nimblechallenge.ui.components.atoms.ButtonIconCommon
import co.jassonkm.nimblechallenge.ui.components.molecules.TextDescription
import co.jassonkm.nimblechallenge.ui.theme.White

@Composable
fun SurveyDetailHeader(titleDescription: String, description: String, onClickBack: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
    ){
        ButtonIconCommon(
            onClick = onClickBack,
            icon = R.drawable.back_icon,
            color = White,
            modifierButton = Modifier
                .width(30.dp)
                .height(30.dp),
            modifierIcon = Modifier
                .width(30.dp)
                .height(30.dp)

        )
        TextDescription(titleDescription = titleDescription, description = description)
    }
}
@Preview
@Composable
fun SurveyDetailHeaderPreview() {
    SurveyDetailHeader(titleDescription = "Working from home Check-In", description = "We would like to know how you feel about our work from home (WFH) experience.", onClickBack = {})
}