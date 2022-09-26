package io.github.nhths.cryptolist.data.service

import io.github.nhths.cryptolist.data.model.CryptoDetailsModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoDetailsService {

    @GET("coins/{cryptoId}")
    fun getCryptoDetails(@Path("cryptoId") cryptoId: String): Call<CryptoDetailsModel>

}