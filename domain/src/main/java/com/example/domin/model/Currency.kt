package com.example.domin.model

data class Currency(
    val id: Int,
    val name: String,
    val code: String,
    val symbol: String,
    val perToDollar: Double,
)
