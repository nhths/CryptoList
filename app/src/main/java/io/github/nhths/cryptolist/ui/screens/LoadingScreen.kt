package io.github.nhths.cryptolist.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.nhths.cryptolist.ui.theme.OrangeMain

@Composable
fun LoadingScreen(){
    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        CircularProgressIndicator(
            color = OrangeMain,
            modifier = Modifier
                .height(36.dp)
                .width(36.dp)
        )
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PreviewLoadingScreen(){
    LoadingScreen()
}