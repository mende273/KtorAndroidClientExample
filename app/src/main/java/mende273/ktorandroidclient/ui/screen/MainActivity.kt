package mende273.ktorandroidclient.ui.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mende273.ktorandroidclient.ui.component.DrinkItem
import mende273.ktorandroidclient.ui.theme.KtorAndroidClientTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            KtorAndroidClientTheme {
                val viewModel: MainViewModel by viewModel()
                val quoteItems by viewModel.items.collectAsStateWithLifecycle()

                LaunchedEffect(key1 = Unit, block = {
                    viewModel.loadItems()
                })

                Scaffold { innerPaddings ->
                    LazyColumn(
                        modifier = Modifier.padding(innerPaddings),
                        verticalArrangement = Arrangement.SpaceBetween, content = {
                            items(quoteItems) {
                                DrinkItem(item = it)
                            }
                        })
                }
            }
        }
    }
}
