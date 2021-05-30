package com.piashcse.currencyconverter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.piashcse.currencyconverter.utils.constants.AppConstants

@Entity
data class ConvertedCurrency(
    @PrimaryKey(autoGenerate = true) val id: Int ,
    @ColumnInfo(name = "convertedCurrency") var convertedCurrency: String = AppConstants.Default.STRING,
    @ColumnInfo(name = "currencyRate") var currencyRate: Double = AppConstants.Default.DOUBLE
)