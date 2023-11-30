package co.jassonkm.nimblechallenge.ui.components.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager

import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.domain.model.SurveyItem
import co.jassonkm.nimblechallenge.ui.components.organisms.TopBarHome
import co.jassonkm.nimblechallenge.ui.components.templates.SurveyCard
import co.jassonkm.nimblechallenge.ui.theme.GradientBrush

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(
    date: String,
    onClickLogout: () -> Unit,
    surveyItems: List<SurveyItem>,
    pagerState: PagerState,
    painterBrush: Brush,
    onCLickNext: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = painterBrush)
            .padding(top = 25.dp),
        verticalArrangement = Arrangement.SpaceBetween

    ) {
        TopBarHome(date = date, day = "Today", onClickLogout = onClickLogout)
        HorizontalPager(state = pagerState, pageCount = surveyItems.size) { page ->
            SurveyCard(
                title = surveyItems[page].title,
                description = surveyItems[page].description,
                onNextClick = onCLickNext,
                surveyItems = surveyItems,
                pagerState = pagerState
            )

        }


    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = false)
@Composable
fun PreviewHomePage() {
    HomePage(
        date = "Monday, JUNE 15",
        onClickLogout = {},
        surveyItems = listOf(),
        pagerState = rememberPagerState(),
        painterBrush = GradientBrush,
        onCLickNext = {})
}