package mende273.ktorandroidclient.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mende273.ktorandroidclient.ui.component.DrinkItem
import mende273.ktorandroidclient.ui.theme.KtorAndroidClientTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KtorAndroidClientTheme {
                val viewModel: MainViewModel by viewModel()
                val quoteItems by viewModel.items.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = Unit, block = {
                    viewModel.loadItems()
                })

                LazyColumn(verticalArrangement = Arrangement.SpaceBetween, content = {
                    items(quoteItems) {
                        DrinkItem(item = it)
                    }
                })
            }
        }
    }
}
