package com.example.data.repository

import com.example.data.local.dao.CurrencyDao
import com.example.data.local.mapper.toCurrency
import com.example.data.local.mapper.toCurrencyEntity
import com.example.data.remote.ApiService
import com.example.domin.model.Currency
import com.example.domin.repository.CurrencyRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.first

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyDao: CurrencyDao,
    private val currencyApi: ApiService,
) : CurrencyRepository {

    override suspend fun getCurrencyByCode(code: String): Currency =
        currencyDao.getCurrencyByCode(code).first().toCurrency()

    override suspend fun getAllCurrencies(): List<Currency> =
        currencyDao.getAllCurrencies().map { it.toCurrency() }

    override suspend fun getAllFromApi() {
        currencyDao.upsertCurrency(currencyApi.getAllCurrencies().toCurrencyEntity())
    }

}