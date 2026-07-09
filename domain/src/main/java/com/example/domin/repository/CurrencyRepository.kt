package com.example.domin.repository

import com.example.domin.model.Currency

interface CurrencyRepository{
    suspend fun getCurrencyByCode(code: String): Currency
    suspend fun getAllCurrencies(): List<Currency>
    suspend fun getAllFromApi()
}