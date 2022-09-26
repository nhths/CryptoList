package io.github.nhths.cryptolist.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import io.github.nhths.cryptolist.vm.CryptoDetailsViewModel

@Composable
fun CryptoDetailsScreen(
    viewModel: CryptoDetailsViewModel = CryptoDetailsViewModel()
){
    Text(text = "crypto details")
}