package com.example.data.repository

import com.example.data.local.dao.HistoryDao
import com.example.data.local.mapper.toHistory
import com.example.data.local.mapper.toHistoryEntity
import com.example.domin.model.History
import com.example.domin.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class HistoryRepositoryImpl @Inject constructor(
    private val historyDao: HistoryDao,
) : HistoryRepository {

    override fun getHistory(): Flow<List<History>> =
        historyDao.getAllHistory().map { list -> list.map { it.toHistory() } }

    override suspend fun insertHistory(history: History) {
        historyDao.insertHistory(history.toHistoryEntity())
    }

    override suspend fun deleteHistory(history: History) {
        historyDao.deleteHistory(history.toHistoryEntity())
    }

    override suspend fun deleteAllHistory() {
        historyDao.deleteAllHistory()
    }
}