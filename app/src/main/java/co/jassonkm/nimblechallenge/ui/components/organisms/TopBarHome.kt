package co.jassonkm.nimblechallenge.ui.components.organisms

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.jassonkm.nimblechallenge.R
import co.jassonkm.nimblechallenge.ui.components.atoms.ButtonIconCommon
import co.jassonkm.nimblechallenge.ui.components.molecules.TextTitle
import co.jassonkm.nimblechallenge.ui.theme.Black

@Composable
fun TopBarHome(date: String, day: String, onClickLogout: () -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp),
    ) {
        TextTitle(title = day, date = date)
        ButtonIconCommon(
            onClick = { expanded = true },
            icon = R.drawable.profile_logo,
            color = Black,
            modifierButton = Modifier
                .width(70.dp)
                .height(70.dp),
            modifierIcon = Modifier
                .width(70.dp)
                .height(70.dp)
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(text = {
                Text(text = "Logout")
            }, onClick = onClickLogout)
        }
    }
}


@Preview
@Composable
fun PreviewTopBar() {
    TopBarHome(date = "Monday, JUNE 15", day = "Today", onClickLogout = {})
}