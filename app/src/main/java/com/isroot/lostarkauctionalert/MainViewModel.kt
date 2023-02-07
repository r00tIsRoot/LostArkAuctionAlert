package com.isroot.lostarkauctionalert

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.isroot.lostarkauctionalert.data.DTO.AuctionOption
import com.isroot.lostarkauctionalert.repositories.LoADataSource
import com.isroot.lostarkauctionalert.repositories.LoARepository

class MainViewModel(application: Application) : BaseViewModel(application), LoADataSource.GetAuctionInfoCallback {
    val _apiKey = MutableLiveData<String>()
    val apiKey: LiveData<String> = _apiKey

    private var loARepository: LoARepository

//    fun setApiKey(apiKey: String) {
//        _apiKey.value = apiKey
//    }

    init {
        _apiKey.value = ""
        loARepository = LoARepository.getInstance(application)
    }

    fun onClickStartApiBtn() {
        Log.d("isrootLog", "onClickStartApiBtn")
        if(apiKey.value!!.isNotEmpty()) {
            loARepository.getAuctionOption("bearer ${apiKey.value!!}", this)
        }
    }

    override fun onSucceed(auctionOption: AuctionOption) {
        Log.d("isrootLog", "response auctionOption is : $auctionOption")

    }

    override fun onFailed(errMsg: String) {
        Log.d("isrootLog", "response auctionOption is : $errMsg")
    }


}