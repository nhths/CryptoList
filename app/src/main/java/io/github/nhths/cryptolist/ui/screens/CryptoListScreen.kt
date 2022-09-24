package io.github.nhths.cryptolist.ui.screens

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CryptoListScreen(
    onCryptoSelected:() -> Unit
){
    Surface(
        onClick = { onCryptoSelected() }
    ) {
        Text(text = "crypto list")
    }
}