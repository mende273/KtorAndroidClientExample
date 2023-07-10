package mende273.ktorandroidclient.data.repository

import mende273.ktorandroidclient.data.model.QuotesResults
import mende273.ktorandroidclient.network.ApiService

class RemoteRepositoryImpl(
    private val apiService: ApiService
) : RemoteRepository {
    override suspend fun getQuotes(): Result<QuotesResults> {
        return try {
            Result.success(apiService.getQuotes())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
