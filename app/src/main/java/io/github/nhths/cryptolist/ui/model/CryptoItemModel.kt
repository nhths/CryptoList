package io.github.nhths.cryptolist.ui.model

data class CryptoItemModel(
    val id: String,
    val name: String,
    val ticker: String,
    val currencySymbol: String,
    val price: Double,
    val diffPercentage: Double,
    val imageUrl: String,
    )