package io.github.nhths.cryptolist.data.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CryptoDetailsModel(
    @field:Json(name = "id")
    val id: String,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "image")
    val imageUrl: ImageUrl,

    @field:Json(name = "description")
    val description: Description,

    @field:Json(name = "categories")
    val categories: List<String>
)

@JsonClass(generateAdapter = true)
data class ImageUrl(
    @field:Json(name = "large")
    val url: String
)

@JsonClass(generateAdapter = true)
data class Description(
    @field:Json(name = "en")
    val text: String,
)