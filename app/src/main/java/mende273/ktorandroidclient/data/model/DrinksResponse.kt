package mende273.ktorandroidclient.data.model

import kotlinx.serialization.Serializable

@Serializable
data class DrinksResponse(
    val drinks: List<Drink>
)