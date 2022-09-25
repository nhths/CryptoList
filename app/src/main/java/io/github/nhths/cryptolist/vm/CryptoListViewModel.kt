package io.github.nhths.cryptolist.vm

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.nhths.cryptolist.ui.model.CryptoItemModel
import io.github.nhths.cryptolist.ui.model.CurrencyItemModel
import java.util.Currency

class CryptoListViewModel(application: Application) : AndroidViewModel(application) {

    //stub
    val cryptoList: LiveData<List<CryptoItemModel>> = MutableLiveData<List<CryptoItemModel>>()

    val currencyList: LiveData<List<CurrencyItemModel>> = MutableLiveData<List<CurrencyItemModel>>()

    private val _selectedCurrency: MutableLiveData<CurrencyItemModel> = MutableLiveData<CurrencyItemModel>()
    val selectedCurrency: LiveData<CurrencyItemModel> = _selectedCurrency

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