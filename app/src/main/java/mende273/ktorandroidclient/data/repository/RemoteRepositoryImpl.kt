package mende273.ktorandroidclient.data.repository

import io.ktor.client.call.body
import mende273.ktorandroidclient.data.model.Drink
import mende273.ktorandroidclient.data.model.DrinksResponse
import mende273.ktorandroidclient.network.ApiService

class RemoteRepositoryImpl(
    private val apiService: ApiService
) : RemoteRepository {
    override suspend fun getDrinks(): Result<List<Drink>> =
        runCatching {
            apiService.getDrinks().body<DrinksResponse>().drinks
        }
}
