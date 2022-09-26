package io.github.nhths.cryptolist.vm

import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.accompanist.swiperefresh.SwipeRefreshState
import io.github.nhths.cryptolist.ui.model.CryptoItemModel
import io.github.nhths.cryptolist.ui.model.CurrencyItemModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class CryptoListViewModel() : ViewModel() {

    enum class State{
        LOADING,
        ERROR,
        SHOWING
    }

    private val _state = MutableLiveData<State>(State.LOADING)
    val state:LiveData<State> = _state

    private val _refreshState = MutableLiveData<SwipeRefreshState>(SwipeRefreshState(false))
    val refreshState: LiveData<SwipeRefreshState> = _refreshState

    private val _snackBarState = MutableLiveData<SnackbarHostState>(SnackbarHostState())
    val snackbarState: LiveData<SnackbarHostState> = _snackBarState

    //stub
    private val _cryptoList = MutableLiveData<List<CryptoItemModel>>(emptyList())
    val cryptoList: LiveData<List<CryptoItemModel>> = _cryptoList

    private val _currencyList = MutableLiveData<List<CurrencyItemModel>>(emptyList())
    val currencyList: LiveData<List<CurrencyItemModel>> = _currencyList

    private val _selectedCurrency: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val selectedCurrency: LiveData<Int> = _selectedCurrency

    fun onListUpdate(){
        _refreshState.value!!.isRefreshing = true
        viewModelScope.launch {
            delay(3000)
            snackbarState.value!!.showSnackbar("dfsd")
            _refreshState.value!!.isRefreshing = false
        }
    }

    fun onItemSelected(item: CryptoItemModel){
        
    }

    fun onCurrencySelected(pos: Int, item: CurrencyItemModel){
        _selectedCurrency.postValue(pos)
    }

    override fun onCleared() {
        super.onCleared()
    }

}