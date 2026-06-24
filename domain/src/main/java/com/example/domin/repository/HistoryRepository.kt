package com.example.domin.repository

import com.example.domin.model.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {

    fun getHistory(): Flow<List<History>>

    suspend fun insertHistory(history: History)

    suspend fun deleteHistory(history: History)

    suspend fun deleteAllHistory()

}