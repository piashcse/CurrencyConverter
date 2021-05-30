package com.piashcse.currencyconverter.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.piashcse.currencyconverter.utils.constants.AppConstants

@Entity
data class Currency(
    @PrimaryKey(autoGenerate = true) val id: Int ,
    @ColumnInfo(name = "currency") var currency: String = AppConstants.Default.STRING,
    @ColumnInfo(name = "country") var country: String = AppConstants.Default.STRING
)