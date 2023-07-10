package mende273.ktorandroidclient.data.repository

import mende273.ktorandroidclient.data.model.QuotesResults

interface RemoteRepository {
    suspend fun getQuotes(): Result<QuotesResults>
}
