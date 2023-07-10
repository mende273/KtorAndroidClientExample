package mende273.ktorandroidclient.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mende273.ktorandroidclient.data.model.Quote
import mende273.ktorandroidclient.data.repository.RemoteRepositoryImpl

class MainViewModel(private val remoteRepositoryImpl: RemoteRepositoryImpl) : ViewModel() {
    private val _items: MutableStateFlow<List<Quote>> = MutableStateFlow(emptyList())
    val items: StateFlow<List<Quote>> = _items

    suspend fun loadItems() {
        viewModelScope.launch {
            remoteRepositoryImpl.getQuotes().onSuccess { quotesResult ->
                _items.update {
                    quotesResult.results
                }
            }.onFailure {
                // something went wrong
            }
        }
    }
}
