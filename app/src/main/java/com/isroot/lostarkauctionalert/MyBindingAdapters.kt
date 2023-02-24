package com.isroot.lostarkauctionalert

import androidx.databinding.BindingAdapter
import com.isroot.lostarkauctionalert.data.Entities.ApiKey
import com.isroot.lostarkauctionalert.views.ApiKeysListView
import com.isroot.lostarkauctionalert.views.ApiKeysListViewListener


@BindingAdapter("binding:listener", "binding:apiKeys")
fun bindApiKeys(
    view: ApiKeysListView,
    listener: ApiKeysListViewListener,
    apiKeys: List<ApiKey>
){
    view.apiKeys = apiKeys
    view.listener = listener
}