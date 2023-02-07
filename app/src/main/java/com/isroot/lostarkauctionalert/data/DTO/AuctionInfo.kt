package com.isroot.lostarkauctionalert.data.DTO

data class AuctionInfo(
    val StartPrice: Int,
    val BuyPrice: Int,
    val BidPrice: Int,
    val EndDate: String,
    val BidCount: Int,
    val BidStartPrice: Int,
    val IsCompetitive: Boolean,
    val TradeAllowCount: Int
    )