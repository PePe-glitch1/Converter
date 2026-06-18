package com.example.domin.usecase

import javax.inject.Inject

class ConvertCurrencyUseCase {
        operator fun invoke(value: Double, rate: Double): Double {
            return value * rate
        }
}