package com.isroot.lostarkauctionalert.views

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.AbstractComposeView
import androidx.compose.ui.unit.dp
import com.isroot.lostarkauctionalert.data.Entities.ApiKey

@Composable
fun ApiKeysList(
    listener: ApiKeysListViewListener,
    apiKeys: List<ApiKey>,
    modifier: Modifier = Modifier
) {
    // We save the scrolling position with this state
    val scrollState = rememberLazyListState()

    LazyColumn(state = scrollState,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "ApiKey 이름",
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "apiKey",
                    modifier = Modifier.weight(1f)
                )
            }
        }

        items(apiKeys) { apiKey ->
            Surface(modifier = Modifier.clickable {
                Log.d("isrootLog", "items clickable : ${apiKey.apiKey} / ${apiKey.apiName}")
                listener.onClickApiKey(apiKey)
            }) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(text = "${apiKey.apiName}")
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(text = "${apiKey.apiKey}")
                }
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

    lateinit var listener: ApiKeysListViewListener
    var apiKeys by mutableStateOf(listOf<ApiKey>())

    @Composable
    override fun Content() {
        MaterialTheme {
            ApiKeysList(listener, apiKeys)
        }
    }
}

interface ApiKeysListViewListener {
    fun onClickApiKey(apiKey: ApiKey)
}