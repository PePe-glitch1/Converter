package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class History(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fromCurrencyId: Int,
    val toCurrencyId: Int,
    val amount: Double,
    val result: Double,
    val date: String,
)
