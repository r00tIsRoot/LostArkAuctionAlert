package com.isroot.lostarkauctionalert.repositories

import com.isroot.lostarkauctionalert.data.DTO.AuctionOption

interface LoADataSource {
    fun getAuctionOption(apiKey: String, callback: GetAuctionInfoCallback)

    interface GetAuctionInfoCallback {
        fun onSucceed(auctionOption: AuctionOption)
        fun onFailed(errMsg: String)
    }
}