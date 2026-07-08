package com.example.data.local.mapper

import com.example.data.local.entity.CurrencyEntity
import com.example.domin.model.Currency

fun CurrencyEntity.toCurrency() = Currency(
    code = code,
    perToDollar = perToDollar,
    data = data,
)

fun Currency.toCurrencyEntity() = CurrencyEntity(
    code = code,
    perToDollar = perToDollar,
    data = data,
)