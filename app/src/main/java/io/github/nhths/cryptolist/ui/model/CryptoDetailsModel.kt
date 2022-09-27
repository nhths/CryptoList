package io.github.nhths.cryptolist.ui.model

data class CryptoDetailsModel(
    val id: String,
    val name: String,
    val imageUrl: String,
    val description: String,
    val categories: String
)