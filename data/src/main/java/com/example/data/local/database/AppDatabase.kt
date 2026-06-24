package com.example.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.dao.CurrencyDao
import com.example.data.local.dao.HistoryDao
import com.example.data.local.entity.CurrencyEntity
import com.example.data.local.entity.HistoryEntity

@Database(
    entities = [CurrencyEntity::class, HistoryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun historyDao(): HistoryDao
}