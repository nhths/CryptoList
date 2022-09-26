package io.github.nhths.cryptolist.data.model

data class CryptoModel (
    val id: String,
    val name: String,
    val ticker: String,
    val price: Double,
    val diffPercentage: Double,
    val imageUrl: String
)