package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.data.local.entity.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

     @Query("SELECT * FROM currency Where code = :code")
     fun getCurrencyByCode(code: String): Flow<CurrencyEntity>

     @Query("SELECT * FROM currency")
     suspend fun getAllCurrencies(): List<CurrencyEntity>

     @Upsert
     suspend fun upsertCurrency(currency: List<CurrencyEntity>)

}