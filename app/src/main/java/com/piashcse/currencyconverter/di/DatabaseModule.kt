package com.piashcse.currencyconverter.di

import android.content.Context
import androidx.room.Room
import com.piashcse.currencyconverter.data.datasource.local.AppDatabase
import com.piashcse.currencyconverter.data.datasource.local.DataStoreManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideDB(@ApplicationContext applicationContext: Context) = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "user_database"
    ).build()

    @Singleton
    @Provides
    fun provideCurrencyDao(db: AppDatabase) = db.currencyDao()

    @Singleton
    @Provides
    fun provideConvertedCurrencyDao(db: AppDatabase) = db.convertedCurrencyDao()

    @Singleton
    @Provides
    fun provideDataStore(@ApplicationContext appContext: Context): DataStoreManager {
        return DataStoreManager(appContext)
    }
}