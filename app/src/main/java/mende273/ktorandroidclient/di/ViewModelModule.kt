package mende273.ktorandroidclient.di

import mende273.ktorandroidclient.ui.screen.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
