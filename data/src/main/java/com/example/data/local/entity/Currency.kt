package com.example.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currency")
data class Currency(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val code: String,
    val perToDollar: Double,
)
