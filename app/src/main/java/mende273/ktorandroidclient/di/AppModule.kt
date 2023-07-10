package mende273.ktorandroidclient.di

import org.koin.dsl.module

val appModule = module {
    includes(viewModelModule, networkModule, repositoryModule)
}
