package com.example.data.local.di

import com.example.data.repository.CurrencyRepositoryImpl
import com.example.data.repository.HistoryRepositoryImpl
import com.example.domin.repository.CurrencyRepository
import com.example.domin.repository.HistoryRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindCurrencyRepository(
        impl: CurrencyRepositoryImpl
    ): CurrencyRepository

    @Binds
    @Singleton
    abstract fun bindHistoryRepository(
        impl: HistoryRepositoryImpl
    ): HistoryRepository
}