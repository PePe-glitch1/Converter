package com.example.data.local.mapper

import com.example.data.local.entity.CurrencyEntity
import com.example.domin.model.Currency

fun CurrencyEntity.toCurrency() = Currency(
    id = id,
    name = name,
    code = code,
    perToDollar = perToDollar,
)

fun Currency.toCurrencyEntity() = CurrencyEntity(
    id = id,
    name = name,
    code = code,
    perToDollar = perToDollar,
)