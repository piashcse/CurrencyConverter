package com.piashcse.currencyconverter.data.models.live


import com.google.gson.annotations.SerializedName
import com.piashcse.currencyconverter.data.models.list.Error

data class BaseConvertedCurrency(
    @SerializedName("privacy")
    val privacy: String,
    @SerializedName("quotes")
    val quotes: Map<String, Double>,
    @SerializedName("source")
    val source: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: Error,
    @SerializedName("terms")
    val terms: String,
    @SerializedName("timestamp")
    val timestamp: Long
)