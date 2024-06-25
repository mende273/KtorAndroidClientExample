package mende273.ktorandroidclient.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import mende273.ktorandroidclient.data.model.Drink

@Composable
fun DrinkItem(item: Drink) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        NetworkImage(
            modifier = Modifier.size(50.dp),
            url = item.strDrinkThumb ?: "",
            contentScale = ContentScale.Crop
        )
        Text(text = item.strDrink ?: "")
    }
}