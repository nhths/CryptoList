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
    val cryptoList: LiveData<List<CryptoItemModel>> = MutableLiveData<List<CryptoItemModel>>()

    val currencyList: LiveData<List<CurrencyItemModel>> = MutableLiveData<List<CurrencyItemModel>>()

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