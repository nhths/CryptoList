package io.github.nhths.cryptolist.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.nhths.cryptolist.ui.model.CryptoItemModel
import io.github.nhths.cryptolist.ui.model.CurrencyItemModel

class CryptoListViewModel() : ViewModel() {

    enum class State{
        LOADING,
        ERROR,
        SHOWING
    }

    private val _state = MutableLiveData<State>()
    val state:LiveData<State> = _state

    //stub
    private val _cryptoList = MutableLiveData<List<CryptoItemModel>>()
    val cryptoList: LiveData<List<CryptoItemModel>> = _cryptoList

    private val _currencyList = MutableLiveData<List<CurrencyItemModel>>()
    val currencyList: LiveData<List<CurrencyItemModel>> = _currencyList

    private val _selectedCurrency: MutableLiveData<CurrencyItemModel> = MutableLiveData<CurrencyItemModel>()
    val selectedCurrency: LiveData<CurrencyItemModel> = _selectedCurrency

    init {
        _state.postValue(State.SHOWING)
    }

    fun onListUpdate(){

    }

    fun onItemSelected(item: CryptoItemModel){
        
    }

    fun onCurrencySelected(item: CurrencyItemModel){
        _selectedCurrency.value = item
    }

    override fun onCleared() {
        super.onCleared()
    }

}