package com.example.data.local.di

import android.content.Context
import androidx.room.Room
import com.example.data.local.dao.CurrencyDao
import com.example.data.local.dao.HistoryDao
import com.example.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext ctx: Context): AppDatabase =
        Room.databaseBuilder(ctx, AppDatabase::class.java, "app_database").build()

    @Singleton
    @Provides
    fun provideCurrencyDao(database: AppDatabase): CurrencyDao = database.currencyDao()

    @Singleton
    @Provides
    fun provideHistoryDao(database: AppDatabase): HistoryDao = database.historyDao()
}