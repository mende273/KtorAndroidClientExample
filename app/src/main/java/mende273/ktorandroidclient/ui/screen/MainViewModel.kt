package mende273.ktorandroidclient.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import mende273.ktorandroidclient.data.model.Drink
import mende273.ktorandroidclient.data.repository.RemoteRepositoryImpl

class MainViewModel(private val remoteRepositoryImpl: RemoteRepositoryImpl) : ViewModel() {
    private val _items: MutableStateFlow<List<Drink>> = MutableStateFlow(emptyList())
    val items: StateFlow<List<Drink>> = _items

    suspend fun loadItems() {
        viewModelScope.launch {
            remoteRepositoryImpl.getDrinks().fold(
                onSuccess = { drinks ->
                    _items.update { drinks }
                }, onFailure = {
                    // something went wrong
                })
        }
    }
}
