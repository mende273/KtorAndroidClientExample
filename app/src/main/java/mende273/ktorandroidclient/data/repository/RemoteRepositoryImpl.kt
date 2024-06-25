package mende273.ktorandroidclient.data.repository

import io.ktor.client.call.body
import mende273.ktorandroidclient.network.ApiService
import mende273.ktorandroidclient.data.model.DrinksResponse

class RemoteRepositoryImpl(
    private val apiService: ApiService
) : RemoteRepository {
    override suspend fun getDrinks(): Result<DrinksResponse> {
        return try {
            Result.success(apiService.getDrinks().body())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
