package io.github.nhths.cryptolist.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.nhths.cryptolist.ui.model.CryptoDetailsModel

class CryptoDetailsViewModel(val cryptoId: String) : ViewModel() {

    enum class State{
        LOADING,
        ERROR,
        SHOWING
    }

    private val _state = MutableLiveData<State>(State.LOADING)
    val state: LiveData<State> = _state

    private val _cryptoDetails = MutableLiveData<CryptoDetailsModel>(CryptoDetailsModel("", "", "","",""))
    val cryptoDetails: LiveData<CryptoDetailsModel> = _cryptoDetails

    init {
        //load crypto description
    }

    fun onRefresh(){
        _state.postValue(State.LOADING)
    }
}