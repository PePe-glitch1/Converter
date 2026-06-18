package com.example.domin.usecase

import com.example.domin.repository.RateRepository
import javax.inject.Inject

class ConvertRateUseCase @Inject constructor(
    private val repository: RateRepository
) {
    suspend operator fun invoke(name1: String, name2: String): Double {
        val rates = repository.getPerToDollar(name1, name2)
        return rates.first / rates.second
    }
}