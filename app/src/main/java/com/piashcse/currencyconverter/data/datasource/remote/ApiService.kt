package com.piashcse.currencyconverter.data.datasource.remote

import com.piashcse.currencyconverter.data.models.list.BaseCurrency
import com.piashcse.currencyconverter.data.models.live.BaseConvertedCurrency
import com.piashcse.currencyconverter.utils.constants.AppConstants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
interface ApiService {
    @GET(AppConstants.EndPoints.LIST_CURRENCY + AppConstants.API_KEY_CURRENCY_LAYER)
    suspend fun currencyList(): Response<BaseCurrency>

    @GET(AppConstants.EndPoints.LIVE_CURRENCY + AppConstants.API_KEY_CURRENCY_LAYER)
    suspend fun currencyConvertedList(@Query("source") sourceCurrency: String): Response<BaseConvertedCurrency>
}