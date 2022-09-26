package io.github.nhths.cryptolist.data.model

import com.squareup.moshi.FromJson
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonQualifier

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class ImageUrl

@Retention(AnnotationRetention.RUNTIME)
@JsonQualifier
annotation class DescriptionEN

@JsonClass(generateAdapter = true)
data class CryptoDetailsModel(
    @field:Json(name = "id")
    val Id: String,

    @field:Json(name = "name")
    val name: String,

    @field:Json(name = "id")
    @ImageUrl
    val imageUrl: String,

    @field:Json(name = "description")
    val description: String,

    @field:Json(name = "categories")
    val categories: List<String>
)

@FromJson
@ImageUrl
fun fromJsonImageUrl(json: Map<String, Any?>): String {
    return json.getValue("large") as String
}

@FromJson
@DescriptionEN
fun fromJsonDescription(json: Map<String, Any?>): String {
    return json.getValue("en") as String
}