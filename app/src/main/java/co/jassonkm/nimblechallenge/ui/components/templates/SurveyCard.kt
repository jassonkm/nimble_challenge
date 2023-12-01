package co.jassonkm.nimblechallenge.ui.components.templates

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.data.remote.model.response.DataSurvey
import co.jassonkm.nimblechallenge.domain.model.SurveyItem
import co.jassonkm.nimblechallenge.ui.components.atoms.HorizontalPageIndicator
import co.jassonkm.nimblechallenge.ui.components.organisms.HomeFooter

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SurveyCard(
    title: String,
    description: String,
    onNextClick: () -> Unit,
    surveyItems: List<DataSurvey>,
    pagerState: PagerState
    ) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .width(280.dp)
            .padding(vertical = 50.dp),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HorizontalPageIndicator(surveyItems = surveyItems, pagerState = pagerState)
        HomeFooter(
            title = title,
            description = description,
            onClickNext = onNextClick,

            )
    }
}

