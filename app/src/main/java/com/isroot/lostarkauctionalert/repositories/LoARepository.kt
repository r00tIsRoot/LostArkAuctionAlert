package com.isroot.lostarkauctionalert.repositories

import android.app.Application
import com.isroot.lostarkauctionalert.data.Entities.ApiKey
import com.isroot.lostarkauctionalert.data.L1A3DB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoARepository() {

    companion object {
        private var instance: LoARepository? = null
        private lateinit var  app: Application
        private lateinit var mRemoteLoADataSourceImpl: LoADataSource
        private lateinit var mLocalLoADataSourceImpl: LoADataSource
        private lateinit var l1A3DB: L1A3DB


        fun getInstance(_app: Application): LoARepository {
            return instance ?: synchronized(this) {
                instance ?: LoARepository().also {
                    app = _app
                    instance = it
                    l1A3DB = L1A3DB.getInstance(_app)!!
                    mRemoteLoADataSourceImpl = RemoteLoADataSourceImpl.getInstance()
                    mLocalLoADataSourceImpl = LocalLoADataSourceImpl.getInstance(l1A3DB)
                }
            }
        }

    }

    fun getAuctionOption(apiKey: String, callback: LoADataSource.GetAuctionInfoCallback) {
        mRemoteLoADataSourceImpl.getAuctionOption(apiKey, callback)
    }

    fun insertApiKey(apiKey: ApiKey, callback: LoADataSource.InsertApiKeyCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            l1A3DB.apiKeyDao().insert(apiKey)
            callback.onInsertApiKeyCallback()
        }
    }

    fun getAllApiKeys(callback:LoADataSource.GetAllApiKeysCallback) {
        CoroutineScope(Dispatchers.IO).launch {
            callback.onGetAllApiKeysCallback(l1A3DB.apiKeyDao().getAll())
        }
    }

    fun getApiKeyByName(apiName: String): String {
        return l1A3DB.apiKeyDao().getApiKeyByName(apiName).toString()
    }
}