package com.example.data.local.mapper

import com.example.data.local.entity.CurrencyEntity
import com.example.data.remote.dto.CurrencyDto
import com.example.domin.model.Currency

fun CurrencyEntity.toCurrency() = Currency(
    code = code,
    perToDollar = perToDollar,
    data = data,
)

fun CurrencyDto.toCurrencyEntity() : List<CurrencyEntity> {
    return usd.map { (code, value) ->
        CurrencyEntity(
            code = code,
            perToDollar = value,
            data = date
        )
    }
}