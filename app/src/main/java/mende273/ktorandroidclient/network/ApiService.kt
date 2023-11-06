package mende273.ktorandroidclient.network

import io.ktor.client.HttpClient
import io.ktor.client.request.get

class ApiService(private val client: HttpClient) {

    companion object {
        private const val END_POINT = "https://api.quotable.io/"
        private const val QUOTES = "quotes"
    }

    suspend fun getQuotes() = client.get("$END_POINT$QUOTES")
}
