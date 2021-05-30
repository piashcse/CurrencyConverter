package com.piashcse.currencyconverter.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.piashcse.currencyconverter.data.models.ConvertedCurrency
import com.piashcse.currencyconverter.data.models.Currency

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
@Database(entities = [Currency::class, ConvertedCurrency::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDao(): CurrencyDao
    abstract fun convertedCurrencyDao(): ConvertedCurrencyDao
}