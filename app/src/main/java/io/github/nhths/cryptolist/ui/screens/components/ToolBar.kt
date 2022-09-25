package io.github.nhths.cryptolist.ui.screens.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import io.github.nhths.cryptolist.ui.theme.TitleTextToolbarStyle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToolBar(
    title: String,
    canNavigateUp: Boolean = false,
    backgroundColor: Color? = null,
    onClickBack: () -> Unit = {}
){
    val colors =
        backgroundColor?.let {
            TopAppBarDefaults.largeTopAppBarColors(
                containerColor = it
            )
        }
            ?: TopAppBarDefaults.largeTopAppBarColors()


    TopAppBar(
        title = {
            Text(
                text = title,
                style = TitleTextToolbarStyle
            )
        },
        navigationIcon = {
            if (canNavigateUp) {
                IconButton(onClick = onClickBack) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
            }
        },
        colors = colors
    )
}

@Preview
@Composable
private fun PreviewToolBar(){
    ToolBar(title = "test", true)
}