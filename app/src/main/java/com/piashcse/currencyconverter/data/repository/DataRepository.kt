package com.piashcse.currencyconverter.data.repository

import com.piashcse.currencyconverter.data.datasource.remote.DataSource
import com.piashcse.currencyconverter.data.models.list.BaseCurrency
import com.piashcse.currencyconverter.data.models.live.BaseConvertedCurrency
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
class DataRepository @Inject constructor(private val dataSource: DataSource) {
    suspend fun currencyList(): Response<BaseCurrency> {
        return dataSource.currencyList()
    }

    suspend fun currencyConvertedList(sourceCurrency: String): Response<BaseConvertedCurrency> {
        return dataSource.currencyConvertedList(sourceCurrency)
    }

}