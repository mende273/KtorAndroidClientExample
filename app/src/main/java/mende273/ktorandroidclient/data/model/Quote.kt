package mende273.ktorandroidclient.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Quote(
    @SerialName("_id")
    val _id: String,
    @SerialName("author")
    val author: String,
    @SerialName("content")
    val content: String,
    @SerialName("tags")
    val tags: List<String>,
    @SerialName("authorSlug")
    val authorSlug: String,
    @SerialName("length")
    val length: Long,
    @SerialName("dateAdded")
    val dateAdded: String,
    @SerialName("dateModified")
    val dateModified: String
)
