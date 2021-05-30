package com.piashcse.currencyconverter.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.piashcse.currencyconverter.data.models.ConvertedCurrency
import com.piashcse.currencyconverter.data.models.Currency
import kotlinx.coroutines.flow.Flow

/**
 * Created by Piash on 5/29/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
@Dao
interface ConvertedCurrencyDao {
    @Query("SELECT * FROM convertedcurrency")
    fun getAll(): Flow<List<ConvertedCurrency>>

    @Insert
    suspend fun insertAll(convertedCurrencies:List<ConvertedCurrency>)

    @Delete
    suspend fun delete(convertedCurrency: ConvertedCurrency)
}