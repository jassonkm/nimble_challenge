package co.jassonkm.nimblechallenge.ui.components.organisms

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.R
import co.jassonkm.nimblechallenge.data.SurveyItem
import co.jassonkm.nimblechallenge.ui.components.atoms.ButtonIconCommon
import co.jassonkm.nimblechallenge.ui.components.atoms.HorizontalPageIndicator
import co.jassonkm.nimblechallenge.ui.components.molecules.TextDescription
import co.jassonkm.nimblechallenge.ui.theme.White

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeFooter(
    title: String,
    description: String,
    onClickNext: () -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
    ) {
        TextDescription(titleDescription = title, description = description)
        Column() {
            Spacer(modifier = Modifier.height(50.dp))
            ButtonIconCommon(
                onClick = onClickNext,
                icon = R.drawable.next_icon,
                color = White,
                modifierButton = Modifier
                    .width(80.dp)
                    .height(80.dp),
                modifierIcon = Modifier
                    .width(80.dp)
                    .height(80.dp)
            )
        }
    }
}

