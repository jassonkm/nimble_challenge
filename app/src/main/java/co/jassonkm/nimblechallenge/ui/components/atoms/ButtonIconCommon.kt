package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource

@Composable
fun ButtonIconCommon(
    onClick: () -> Unit,
    icon: Int,
    color: Color,
    modifierButton: Modifier,
    modifierIcon: Modifier
) {
    IconButton(
        onClick = onClick, modifier = modifierButton
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = "Inicio",
            tint = color,
            modifier = modifierIcon
        )
    }

}
