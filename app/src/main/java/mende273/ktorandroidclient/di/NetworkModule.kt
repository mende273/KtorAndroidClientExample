package mende273.ktorandroidclient.di

import io.ktor.client.HttpClient
import mende273.ktorandroidclient.network.ApiService
import mende273.ktorandroidclient.network.httpClientAndroid
import org.koin.dsl.module

val networkModule = module {
    single { provideApiService(get()) }
    single { provideHttpClient() }
}

fun provideHttpClient(): HttpClient {
    return httpClientAndroid
}

fun provideApiService(httpClient: HttpClient): ApiService {
    return ApiService(httpClient)
}
