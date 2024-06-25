package mende273.ktorandroidclient.data.repository

import mende273.ktorandroidclient.data.model.DrinksResponse

interface RemoteRepository {
    suspend fun getDrinks(): Result<DrinksResponse>
}
