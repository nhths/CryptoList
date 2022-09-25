package io.github.nhths.cryptolist.ui.model

import coil.compose.AsyncImagePainter

data class CryptoItemModel (
    val id: String,
    val name: String,
    val ticker: String,
    val currencySymbol: String,
    val price: Double,
    val diffPercentage: Double,
    val imagePainter: AsyncImagePainter,
    )