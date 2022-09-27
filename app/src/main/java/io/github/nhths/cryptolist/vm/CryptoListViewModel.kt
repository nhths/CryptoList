package io.github.nhths.cryptolist.vm

import androidx.compose.material3.SnackbarHostState
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.accompanist.swiperefresh.SwipeRefreshState
import io.github.nhths.cryptolist.App
import io.github.nhths.cryptolist.R
import io.github.nhths.cryptolist.data.CryptoListRepository
import io.github.nhths.cryptolist.data.CurrencyRepository
import io.github.nhths.cryptolist.data.model.CryptoModel
import io.github.nhths.cryptolist.ui.model.CryptoItemModel
import io.github.nhths.cryptolist.ui.model.CurrencyItemModel
import kotlinx.coroutines.launch

class CryptoListViewModel() : ViewModel() {

    enum class State{
        LOADING,
        ERROR,
        SHOWING
    }

    private val _state = MutableLiveData<State>(State.LOADING)
    val state:LiveData<State> = _state

    private val currencyRepository = CurrencyRepository()
    private val cryptoListRepository = CryptoListRepository()

    private val _refreshState = MutableLiveData<SwipeRefreshState>(SwipeRefreshState(false))
    val refreshState: LiveData<SwipeRefreshState> = _refreshState

    private val _snackBarState = MutableLiveData<SnackbarHostState>(SnackbarHostState())
    val snackbarState: LiveData<SnackbarHostState> = _snackBarState

    val currencyList: LiveData<List<CurrencyItemModel>> = Transformations
        .map(currencyRepository.currencies) {
            it.map {
                CurrencyItemModel(
                    id = it.id,
                    ticker = it.ticker,
                    symbol = it.symbol
                )
            }
        }

    private val _selectedCurrency: MutableLiveData<Int> = MutableLiveData<Int>(0)
    val selectedCurrency: LiveData<Int> = _selectedCurrency

    val cryptoList: LiveData<List<CryptoItemModel>> = Transformations
        .map(cryptoListRepository.cryptoList) {
            it?.let {
                it.map {
                    CryptoItemModel(
                        id = it.id,
                        name = it.name,
                        ticker = it.ticker,
                        currencySymbol = currencyList.value!!.get(selectedCurrency.value!!).symbol,
                        price = it.price,
                        diffPercentage = it.diffPercentage,
                        imageUrl = it.imageUrl
                    )
                }
            }
        }

    val errorObserver = Observer<Throwable> {
        if (state.value == State.LOADING) {
            _state.postValue(State.ERROR)
        } else {
            viewModelScope.launch {
                val message = App.AppStore.app.applicationContext.getString(R.string.error_message_loading)
                snackbarState.value!!.showSnackbar(message)
            }
        }

        refreshState.value!!.isRefreshing = false
    }

    val listDownloadingObserver = Observer<List<CryptoModel>>{
        if (state.value!! != State.SHOWING){
            _state.postValue(State.SHOWING)
        }
        refreshState.value!!.isRefreshing = false
    }

    init {
        cryptoListRepository.listError.observeForever(errorObserver)
        cryptoListRepository.cryptoList.observeForever(listDownloadingObserver)

        currencyList.observeForever { //and don't clear because currencyList child of view model
            cryptoListRepository.updateList(currencyList.value!!.get(selectedCurrency.value!!).id)
        }
    }

    fun onListUpdate(){
        _refreshState.value!!.isRefreshing = true
        cryptoListRepository.updateList(currencyList.value!!.get(selectedCurrency.value!!).id)
    }

    fun onItemSelected(item: CryptoItemModel){
        
    }

    fun onCurrencySelected(pos: Int, item: CurrencyItemModel){
        _selectedCurrency.postValue(pos)
        refreshState.value!!.isRefreshing = true
        cryptoListRepository.updateList(item.id)
    }

    override fun onCleared() {
        cryptoListRepository.listError.removeObserver(errorObserver)
        cryptoListRepository.cryptoList.removeObserver(listDownloadingObserver)
        super.onCleared()
    }

}