package com.example.data.local.mapper

import com.example.data.local.entity.HistoryEntity
import com.example.domin.model.History

fun HistoryEntity.toHistory() = History(
    id = id,
    fromCurrencyCode = fromCurrencyCode,
    toCurrencyCode = toCurrencyCode,
    amount = amount,
    result = result,
    createdAt = createdAt,
)

fun History.toHistoryEntity() = HistoryEntity(
    id = id,
    fromCurrencyCode = fromCurrencyCode,
    toCurrencyCode = toCurrencyCode,
    amount = amount,
    result = result,
    createdAt = createdAt,
)