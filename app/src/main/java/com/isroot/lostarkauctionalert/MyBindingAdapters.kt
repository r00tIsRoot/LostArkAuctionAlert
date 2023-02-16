package com.isroot.lostarkauctionalert

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import com.isroot.lostarkauctionalert.data.Entities.ApiKey
import com.isroot.lostarkauctionalert.views.ApiKeysListView


@BindingAdapter("binding:apiKeys")
fun bindApiKeys(view: ApiKeysListView, apiKeys: List<ApiKey>) {
    view.apiKeys = apiKeys
}