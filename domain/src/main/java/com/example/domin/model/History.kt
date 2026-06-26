package com.example.domin.model

data class History(
    val id: Int = 0,
    val fromCurrencyCode: String,
    val toCurrencyCode: String,
    val amount: Double,
    val result: Double,
) {
    init {
        require(amount >= 0) { "Amount must be non-negative" }
        require(result >= 0) { "Result must be non-negative" }
    }
}
