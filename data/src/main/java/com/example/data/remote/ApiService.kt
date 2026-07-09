package com.example.data.remote

import com.example.data.remote.dto.CurrencyDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("currencies/{currency}")
    suspend fun getAllCurrencies(
        @Path("currency") currency: String = "usd"
    ): CurrencyDto
}