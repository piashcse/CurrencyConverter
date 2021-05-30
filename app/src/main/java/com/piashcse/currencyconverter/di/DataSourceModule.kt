package com.piashcse.currencyconverter.di

import com.piashcse.currencyconverter.data.datasource.remote.ApiService
import com.piashcse.currencyconverter.data.datasource.remote.DataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {
    @Singleton
    @Provides
    fun provideDataSource(apiService: ApiService): DataSource {
        return DataSource(apiService)
    }
}