package io.github.nhths.cryptolist.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CryptoModel (
    @field:Json(name = "id")
    val id: String,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "symbol")
    val ticker: String,

    @field:Json(name = "current_price")
    val price: Double,

    @field:Json(name = "price_change_percentage_24h")
    val diffPercentage: Double,

    @field:Json(name = "image")
    val imageUrl: String
)