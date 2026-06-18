package com.example.domin.repository

interface RateRepository {
    suspend fun getPerToDollar(name1: String, name2: String): Pair<Double, Double>
}