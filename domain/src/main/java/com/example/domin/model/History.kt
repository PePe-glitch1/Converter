package com.example.domin.model

data class History(
    val id: Int = 0,
    val fromCurrency: Currency,
    val toCurrency: Currency,
    val amount: Double,
    val result: Double,
    val createdAt: Long,
)
