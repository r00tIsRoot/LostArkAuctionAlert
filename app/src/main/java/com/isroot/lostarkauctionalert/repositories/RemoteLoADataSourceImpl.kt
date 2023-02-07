package com.isroot.lostarkauctionalert.repositories

import com.isroot.lostarkauctionalert.api.APIs
import com.isroot.lostarkauctionalert.data.DTO.AuctionOption
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RemoteLoADataSourceImpl: LoADataSource {
    val retrofit = Retrofit.Builder()
        .baseUrl("https://developer-lostark.game.onstove.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val _api = retrofit.create(APIs::class.java)
    val api: APIs
        get() = _api

    companion object {
        private var instance: RemoteLoADataSourceImpl? = null


        fun getInstance(): RemoteLoADataSourceImpl {
            return instance ?: synchronized(this) {
                instance ?: RemoteLoADataSourceImpl().also {
                    instance = it
                }
            }
        }

    }


    override fun getAuctionOption(apiKey: String, callback: LoADataSource.GetAuctionInfoCallback) {
        val call = api.getAuctionOption(apiKey)

        call.enqueue(object : Callback<AuctionOption> {
            override fun onResponse(call: Call<AuctionOption>, response: Response<AuctionOption>) {
                if(response.isSuccessful) {
                    callback.onSucceed(response.body()!!)
                } else {
                    callback.onFailed(response.code().toString())
                }
            }

            override fun onFailure(call: Call<AuctionOption>, t: Throwable) {
                callback.onFailed("${t.printStackTrace()}")
            }
        })
    }
}