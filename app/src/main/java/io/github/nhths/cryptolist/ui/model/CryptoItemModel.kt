package io.github.nhths.cryptolist.ui.model

import android.graphics.drawable.AnimatedImageDrawable

data class CryptoItemModel (
    val id: String,
    val name: String,
    val ticker: String,
    val price: Double,
    val diffPercentage: Double,
    val imageDrawable: AnimatedImageDrawable?,
    )