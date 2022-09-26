package io.github.nhths.cryptolist.data.service

import io.github.nhths.cryptolist.data.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CryptoListService {

    @GET("coins/markets")
    fun getCryptoList(@Query("vs_currency") currencyId: String): Call<List<CryptoModel>>

}