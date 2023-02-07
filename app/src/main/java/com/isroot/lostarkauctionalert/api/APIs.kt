package com.isroot.lostarkauctionalert.api

import com.isroot.lostarkauctionalert.data.DTO.AuctionInfo
import retrofit2.Call
import retrofit2.http.GET

interface APIs {
    @GET("/api/v1/auction")
    fun getAuctionInfo(): Call<AuctionInfo>
}