package com.piashcse.currencyconverter.di

import com.piashcse.currencyconverter.data.datasource.remote.DataSource
import com.piashcse.currencyconverter.data.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Created by Piash on 4/9/21
 * Copyright (c) 2021 bjit. All rights reserved.
 * piash.hassan@bjitgroup.com
 * Last modified $file.lastModified
 */
@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideDataRepository(dataSource: DataSource): DataRepository {
        return DataRepository(dataSource)
    }
}