package com.isroot.lostarkauctionalert.repositories

import android.app.Application

class LoARepository() {

    companion object {
        private var instance: LoARepository? = null
        private lateinit var  app: Application
        private lateinit var mRemoteLoADataSourceImpl: LoADataSource


        fun getInstance(_app: Application): LoARepository {
            return instance ?: synchronized(this) {
                instance ?: LoARepository().also {
                    app = _app
                    instance = it
                    mRemoteLoADataSourceImpl = RemoteLoADataSourceImpl.getInstance()
                }
            }
        }

    }

    fun getAuctionOption(apiKey: String, callback: LoADataSource.GetAuctionInfoCallback) {
        mRemoteLoADataSourceImpl.getAuctionOption(apiKey, callback)
    }
}