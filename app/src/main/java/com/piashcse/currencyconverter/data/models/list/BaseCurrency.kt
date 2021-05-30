package com.piashcse.currencyconverter.data.models.list

import com.google.gson.annotations.SerializedName

data class BaseCurrency(
    @SerializedName("currencies")
    val currencies: Map<String, String>,
    @SerializedName("privacy")
    val privacy: String,
    @SerializedName("success")
    val success: Boolean,
    @SerializedName("error")
    val error: Error,
    @SerializedName("terms")
    val terms: String
)