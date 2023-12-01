package co.jassonkm.nimblechallenge.ui.components.pages

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.data.remote.model.response.DataSurvey
import co.jassonkm.nimblechallenge.domain.model.SurveyItem
import co.jassonkm.nimblechallenge.ui.components.atoms.LoadImage
import co.jassonkm.nimblechallenge.ui.components.organisms.TopBarHome
import co.jassonkm.nimblechallenge.ui.components.templates.SurveyCard

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomePage(
    date: String,
    onClickLogout: () -> Unit,
    surveyItems: List<DataSurvey>,
    pagerState: PagerState,
    onCLickNext: () -> Unit
) {
    val imageHd = surveyItems[pagerState.currentPage].attributes.imageUrl+"l"

    Box {
        LoadImage(url = imageHd)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 25.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {

            TopBarHome(date = date, day = "Today", onClickLogout = onClickLogout)
            HorizontalPager(state = pagerState, pageCount = surveyItems.size) { page ->
                SurveyCard(
                    title = surveyItems[page].attributes.title,
                    description = surveyItems[page].attributes.description,
                    onNextClick = onCLickNext,
                    surveyItems = surveyItems,
                    pagerState = pagerState
                )

            }
        }


    }
}
