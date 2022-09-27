package io.github.nhths.cryptolist.vm

import androidx.lifecycle.*
import io.github.nhths.cryptolist.data.CryptoDetailsRepository
import io.github.nhths.cryptolist.ui.model.CryptoDetailsModel

class CryptoDetailsViewModel(val cryptoId: String) : ViewModel() {

    class Factory(private val cryptoId: String) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return CryptoDetailsViewModel(cryptoId) as T
        }
    }

    enum class State{
        LOADING,
        ERROR,
        SHOWING
    }

    private val cryptoDetailsRepository = CryptoDetailsRepository()

    private val _state = MutableLiveData<State>(State.LOADING)
    val state: LiveData<State> = _state

    val cryptoDetails: LiveData<CryptoDetailsModel> = Transformations.map(cryptoDetailsRepository.cryptoDetails){
        cdm ->
            cdm?.let{
                CryptoDetailsModel(
                    id = cdm.id,
                    name = cdm.name,
                    imageUrl = cdm.imageUrl.url,
                    description = cdm.description.text,
                    categories = cdm.categories.joinToString{it}
                )
            }
    }

    val errorObserver = Observer<Throwable> {
        if (state.value != CryptoDetailsViewModel.State.ERROR) {
            _state.postValue(CryptoDetailsViewModel.State.ERROR)
        }
    }

    val listDownloadingObserver = Observer<io.github.nhths.cryptolist.data.model.CryptoDetailsModel>{
        if (state.value!! != CryptoDetailsViewModel.State.SHOWING){
            _state.postValue(CryptoDetailsViewModel.State.SHOWING)
        }
    }

    init {
        cryptoDetailsRepository.update(cryptoId)
        cryptoDetailsRepository.descriptionError.observeForever(errorObserver)
        cryptoDetailsRepository.cryptoDetails.observeForever(listDownloadingObserver)
    }

    fun onRefresh(){
        _state.postValue(State.LOADING)
        cryptoDetailsRepository.update(cryptoId)
    }
}