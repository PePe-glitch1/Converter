package com.example.data.repository

import com.example.data.local.dao.CurrencyDao
import com.example.data.local.mapper.toCurrency
import com.example.domin.model.Currency
import com.example.domin.repository.CurrencyRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.first

class CurrencyRepositoryImpl @Inject constructor(
    private val currencyDao: CurrencyDao
) : CurrencyRepository {

    override suspend fun getCurrencyByCode(code: String): Currency =
        currencyDao.getCurrencyByCode(code).first().toCurrency()
}