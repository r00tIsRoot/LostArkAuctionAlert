package com.isroot.lostarkauctionalert.views

import android.content.Context
import android.util.AttributeSet
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.unit.dp
import com.isroot.lostarkauctionalert.data.Entities.ApiKey

@Composable
fun ApiKeysList(
    apiKeys: List<ApiKey>,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        item {
            Text(text = "ApiKey 이름")
            Spacer(modifier = Modifier.width(10.dp))
        }

        items(apiKeys) { apiKey ->
            Row {
                Text(text = "apiKey 이름: ${apiKey.apiName}")
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "apiKey: ${apiKey.apiKey}")
            }
        }

        // Add another single item
        item {
            Text(text = "Last item")
        }
    }
}

class ApiKeysListView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AbstractComposeView(context, attrs, defStyle) {

    var apiKeys = listOf<ApiKey>()
    var onClick by mutableStateOf({})

    @Composable
    override fun Content() {
        MaterialTheme {
            ApiKeysList(apiKeys, onClick)
        }
    }
}