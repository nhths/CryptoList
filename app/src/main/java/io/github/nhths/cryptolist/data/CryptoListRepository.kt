package io.github.nhths.cryptolist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.nhths.cryptolist.data.model.CryptoModel

class CryptoListRepository {

    private val _cryptoList = MutableLiveData<List<CryptoModel>>(emptyList())
    val cryptoList:LiveData<List<CryptoModel>> = _cryptoList

    fun updateList(){

    }

}