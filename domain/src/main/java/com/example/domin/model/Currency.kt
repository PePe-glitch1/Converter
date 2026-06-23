package com.example.domin.model

data class Currency(
    val id: Int = 0,
    val name: String,
    val code: String,
    val perToDollar: Double,
)
