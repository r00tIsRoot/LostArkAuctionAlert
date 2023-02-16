package com.isroot.lostarkauctionalert.repositories

import com.isroot.lostarkauctionalert.data.DTO.AuctionOption
import com.isroot.lostarkauctionalert.data.Entities.ApiKey

interface LoADataSource {
    fun getAuctionOption(apiKey: String, callback: GetAuctionInfoCallback)
    fun insertApiKey(apiKey: ApiKey)

    interface GetAuctionInfoCallback {
        fun onGetAuctionInfoSucceed(auctionOption: AuctionOption)
        fun onGetAuctionInfoFailed(errMsg: String)
    }

    interface InsertApiKeyCallback {
        fun onInsertApiKeyCallback()
    }

    interface GetAllApiKeysCallback {
        fun onGetAllApiKeysCallback(apiKeys: List<ApiKey>)
    }
}