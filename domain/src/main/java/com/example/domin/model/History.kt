package com.example.domin.model

data class History(
    val id: Int = 0,
    val fromCurrencyCode: String,
    val toCurrencyCode: String,
    val amount: Double,
    val result: Double,
    val createdAt: Long,
)
