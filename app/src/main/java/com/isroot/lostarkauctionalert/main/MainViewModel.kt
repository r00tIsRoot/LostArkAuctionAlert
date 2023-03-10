package com.isroot.lostarkauctionalert.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.isroot.lostarkauctionalert.BaseViewModel
import com.isroot.lostarkauctionalert.data.DTO.AuctionOption
import com.isroot.lostarkauctionalert.data.Entities.ApiKey
import com.isroot.lostarkauctionalert.repositories.LoADataSource
import com.isroot.lostarkauctionalert.repositories.LoARepository
import com.isroot.lostarkauctionalert.views.ApiKeysListViewListener

class MainViewModel(application: Application) : BaseViewModel(application),
    LoADataSource.GetAuctionInfoCallback,
    LoADataSource.InsertApiKeyCallback,
        LoADataSource.GetAllApiKeysCallback,
        ApiKeysListViewListener
{
    val _apiKeyNameStr = MutableLiveData<String>()
    val apiKeyNameStr: LiveData<String> = _apiKeyNameStr
    fun setApiKeyNameStr(apiKeyNameStr: String) {
        _apiKeyNameStr.value = apiKeyNameStr
    }
    val _apiKeyStr = MutableLiveData<String>()
    val apiKeyStr: LiveData<String> = _apiKeyStr

    private val _apiKeys = MutableLiveData<List<ApiKey>>()
    val apiKeys: LiveData<List<ApiKey>> = _apiKeys
    fun setApiKeys(apiKeys: List<ApiKey>) {
        _apiKeys.postValue(apiKeys)
    }

    private val _apiKey = MutableLiveData<ApiKey>()
    val apiKey: LiveData<ApiKey> = _apiKey
    fun setApiKey(apiKey: ApiKey) {
        _apiKey.value = apiKey
    }

    private val _auctionResult = MutableLiveData<AuctionOption>()
    val auctionResult: LiveData<AuctionOption> = _auctionResult
    fun setauctionResult(auctionResult: AuctionOption) {
        _auctionResult.value = auctionResult
    }

    private var loARepository: LoARepository

//    fun setApiKey(apiKey: String) {
//        _apiKey.value = apiKey
//    }

    init {
        _apiKeyStr.value = ""
        _apiKeyNameStr.value = ""
        _apiKeys.value = listOf()
        loARepository = LoARepository.getInstance(application)

        loARepository.getAllApiKeys(this)
    }

    override fun onClickApiKey(apiKey: ApiKey) {
        Log.d("isrootLog", "onClickApiKey")
        if(apiKey.apiName.isNotEmpty() && apiKey.apiKey.isNotEmpty()) {
            loARepository.getAuctionOption("bearer ${apiKey.apiKey}", this)
        }
    }

    fun asApiKey(apiKeyObj: Any): ApiKey {
        return apiKeyObj as ApiKey
    }

    fun onClickStartApiBtn() {
        Log.d("isrootLog", "onClickStartApiBtn")
        if(apiKeyNameStr.value!!.isNotEmpty() && apiKeyStr.value!!.isNotEmpty()) {
            loARepository.getAuctionOption("bearer ${apiKeyStr.value!!}", this)
        }
    }

    override fun onGetAuctionInfoSucceed(auctionOption: AuctionOption) {
        Log.d("isrootLog", "response auctionOption is : $auctionOption")
        setauctionResult(auctionOption)
        val apiKey = ApiKey(apiKeyNameStr.value!!, apiKeyStr.value!!)
        setApiKey(apiKey)
        loARepository.insertApiKey(apiKey, this)

    }
    override fun onGetAuctionInfoFailed(errMsg: String) {
        Log.d("isrootLog", "response auctionOption is : $errMsg")
    }

    override fun onInsertApiKeyCallback() {
        Log.d("isrootLog", "onInsertApiKeyCallback")
        loARepository.getAllApiKeys(this)
    }

    override fun onGetAllApiKeysCallback(apiKeys: List<ApiKey>) {
        Log.d("isrootLog", "onGetAllApiKeysCallback : $apiKeys")
        setApiKeys(apiKeys)
    }


}