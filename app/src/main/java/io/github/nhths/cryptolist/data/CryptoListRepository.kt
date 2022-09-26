package io.github.nhths.cryptolist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.nhths.cryptolist.data.model.CryptoModel
import io.github.nhths.cryptolist.data.service.CryptoListService
import io.github.nhths.cryptolist.utils.API_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CryptoListRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val cryptoListService = retrofit.create(CryptoListService::class.java)

    private val _cryptoList = MutableLiveData<List<CryptoModel>>()
    val cryptoList:LiveData<List<CryptoModel>> = _cryptoList

    private val _listError = MutableLiveData<Throwable>()
    val listError:LiveData<Throwable> = _listError

    fun updateList(currencyId: String){
        download(currencyId)
    }

    fun download(currencyId: String){
        cryptoListService
            .getCryptoList(currencyId)
            .enqueue(object : Callback<List<CryptoModel>> {
                override fun onResponse(
                    call: Call<List<CryptoModel>>,
                    response: Response<List<CryptoModel>>
                ) {
                    _cryptoList.postValue(response.body())
                }

                override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                    _listError.postValue(t)
                }
            })
    }

}