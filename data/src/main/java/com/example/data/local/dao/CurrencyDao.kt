package com.example.data.local.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.data.local.entity.CurrencyEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CurrencyDao {

     @Query("SELECT * FROM currency Where code = :code")
     fun getAllCurrencies(code: String): Flow<CurrencyEntity>

}