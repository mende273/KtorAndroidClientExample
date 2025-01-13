package mende273.ktorandroidclient.ui.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil3.compose.AsyncImage
import coil3.request.ImageRequest

@Composable
fun NetworkImage(
    modifier: Modifier = Modifier,
    url: String,
    contentDescription: String = "",
    contentScale: ContentScale = ContentScale.None
) {
    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .build(),
        contentDescription = contentDescription,
        contentScale = contentScale
    )
}