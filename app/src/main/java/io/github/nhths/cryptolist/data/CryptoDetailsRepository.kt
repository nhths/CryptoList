package io.github.nhths.cryptolist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.nhths.cryptolist.data.model.CryptoDetailsModel
import io.github.nhths.cryptolist.data.service.CryptoDetailsService
import io.github.nhths.cryptolist.utils.API_URL
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class CryptoDetailsRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val cryptoDetailsService = retrofit.create(CryptoDetailsService::class.java)

    private val _cryptoDetails = MutableLiveData<CryptoDetailsModel>()
    val cryptoDetails: LiveData<CryptoDetailsModel> = _cryptoDetails

    private val _descriptionError = MutableLiveData<Throwable>()
    val descriptionError: LiveData<Throwable> = _descriptionError

    fun update(cryptoId: String){
        download(cryptoId)
    }

    fun download(cryptoId: String){
        cryptoDetailsService
            .getCryptoDetails(cryptoId)
            .enqueue(object : Callback<CryptoDetailsModel>{
                override fun onResponse(
                    call: Call<CryptoDetailsModel>,
                    response: Response<CryptoDetailsModel>
                ) {
                    if (response.code() == 429) {
                        _descriptionError.postValue(object : Throwable(){})
                    }
                    _cryptoDetails.postValue(response.body())
                }

                override fun onFailure(call: Call<CryptoDetailsModel>, t: Throwable) {
                   _descriptionError.postValue(t)
                }
            })
    }

}