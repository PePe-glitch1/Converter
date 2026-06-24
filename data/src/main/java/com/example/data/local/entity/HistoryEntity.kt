package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history")
data class HistoryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val fromCurrencyCode: String,
    val toCurrencyCode: String,
    val amount: Double,
    val result: Double,
    val createdAt: Long = System.currentTimeMillis(),
)
