package mende273.ktorandroidclient.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuotesResults(
    @SerialName("count")
    val count: Int,
    @SerialName("totalCount")
    val totalCount: Int,
    @SerialName("page")
    val page: Int,
    @SerialName("totalPages")
    val totalPages: Int,
    @SerialName("results")
    val results: List<Quote>
)
