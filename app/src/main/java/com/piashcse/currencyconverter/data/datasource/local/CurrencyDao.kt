package com.piashcse.currencyconverter.data.datasource.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.piashcse.currencyconverter.data.models.Currency
import kotlinx.coroutines.flow.Flow

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
@Dao
interface CurrencyDao {
    @Query("SELECT * FROM currency")
    fun getAll(): Flow<List<Currency>>

    @Insert
    suspend fun insertAll(currencies:List<Currency>)

    @Delete
    suspend fun delete(currency: Currency)
}