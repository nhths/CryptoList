package io.github.nhths.cryptolist.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.nhths.cryptolist.ui.navigation.MainNavHost
import io.github.nhths.cryptolist.ui.theme.CryptoListTheme

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun AppScreen(){
    CryptoListTheme {
        MainNavHost()
    }
}