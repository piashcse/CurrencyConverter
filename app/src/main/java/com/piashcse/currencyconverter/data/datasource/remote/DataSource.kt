package com.piashcse.currencyconverter.data.datasource.remote

import com.piashcse.currencyconverter.data.models.list.BaseCurrency
import com.piashcse.currencyconverter.data.models.live.BaseConvertedCurrency
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
class DataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun currencyList(): Response<BaseCurrency> {
        return apiService.currencyList()
    }

    suspend fun currencyConvertedList(sourceCurrency: String): Response<BaseConvertedCurrency> {
        return apiService.currencyConvertedList(sourceCurrency)
    }
}