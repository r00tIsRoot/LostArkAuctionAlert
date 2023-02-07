package com.isroot.lostarkauctionalert.api

import com.isroot.lostarkauctionalert.data.DTO.AuctionOption
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface APIs {
    @GET("/auctions/options")
    fun getAuctionOption(@Header("Authorization") apiKey: String): Call<AuctionOption>
}