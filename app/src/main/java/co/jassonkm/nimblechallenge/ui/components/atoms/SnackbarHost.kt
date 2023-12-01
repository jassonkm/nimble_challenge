package co.jassonkm.nimblechallenge.ui.components.atoms

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun SnackbarHost(snackbarHostState: SnackbarHostState) {

    SnackbarHost(hostState = snackbarHostState) { data ->
        Snackbar { Text(text = data.visuals.message) }
    }
}