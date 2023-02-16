package com.isroot.lostarkauctionalert.repositories

import com.isroot.lostarkauctionalert.data.Entities.ApiKey
import com.isroot.lostarkauctionalert.data.L1A3DB

class LocalLoADataSourceImpl: LoADataSource {
    private lateinit var mL1A3DB: L1A3DB


    companion object {
        private var instance: LocalLoADataSourceImpl? = null

        fun getInstance(l1A3DB: L1A3DB): LocalLoADataSourceImpl {
            return instance ?: synchronized(this) {
                instance ?: LocalLoADataSourceImpl().also {
                    instance = it
                    instance!!.mL1A3DB = l1A3DB
                }
            }
        }

    }

    override fun getAuctionOption(apiKey: String, callback: LoADataSource.GetAuctionInfoCallback) {
    }

    override fun insertApiKey(apiKey: ApiKey) {
        mL1A3DB.apiKeyDao().insert(apiKey)
    }
}