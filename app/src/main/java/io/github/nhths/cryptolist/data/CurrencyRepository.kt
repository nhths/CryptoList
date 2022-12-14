package io.github.nhths.cryptolist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.nhths.cryptolist.data.model.CurrencyModel

class CurrencyRepository {

    val currencyList = listOf(
        CurrencyModel(
            id = "usd",
            ticker = "USD",
            symbol = "$"
        ),
        CurrencyModel(
            id = "eur",
            ticker = "EUR",
            symbol = "€"
        )
    )

    private val _currencies = MutableLiveData<List<CurrencyModel>>(currencyList)
    val currencies: LiveData<List<CurrencyModel>> = _currencies

    fun update() {
        _currencies.postValue(currencyList)
    }

}