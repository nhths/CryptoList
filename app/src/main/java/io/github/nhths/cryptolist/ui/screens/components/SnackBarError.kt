package io.github.nhths.cryptolist.ui.screens.components

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.nhths.cryptolist.ui.theme.RedError

@Composable
fun SnackBarError(
    snackbarData: SnackbarData
){
    Snackbar(
        snackbarData = snackbarData,
        containerColor = RedError
    )
}

@Preview
@Composable
private fun PreviewSnackBarError(){
    SnackBarError(
        snackbarData = object : SnackbarData{
            override val visuals: SnackbarVisuals
                get() = object : SnackbarVisuals {
                    override val actionLabel: String?
                        get() = null
                    override val duration: SnackbarDuration
                        get() = SnackbarDuration.Short
                    override val message: String
                        get() = "Was an error while fetching data"
                    override val withDismissAction: Boolean
                        get() = false
                }

            override fun dismiss() = Unit

            override fun performAction() = Unit

        }
    )
}