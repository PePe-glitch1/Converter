package com.example.domin.usecase

import com.example.domin.repository.CurrencyRepository
import javax.inject.Inject

class ConvertRateUseCase @Inject constructor(
    private val repository: CurrencyRepository
) {
    suspend operator fun invoke(name1: String, name2: String): Double {
        val rates1 = repository.getCurrencyByCode(name1)
        val rates2 = repository.getCurrencyByCode(name2)
        return rates1.perToDollar / rates2.perToDollar
    }
}