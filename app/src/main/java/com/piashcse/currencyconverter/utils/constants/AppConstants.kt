package com.piashcse.currencyconverter.utils.constants

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
object AppConstants {
    const val BASE_URL = "http://api.currencylayer.com/"
    const val API_KEY_CURRENCY_LAYER = "?access_key=7e280f1772e305ad2601ba89cd657aae"

    object EndPoints {
        const val LIVE_CURRENCY = "live"
        const val LIST_CURRENCY = "list"
    }

    object CommonDialog {
        const val CUSTOM_DIALOG_LEFT_MARGIN = 20
        const val CUSTOM_DIALOG_RIGHT_MARGIN = 20
        const val MAX_HEIGHT = 300
    }
    object Default {
        const val STRING = ""
        const val INT = 0
        const val LONG = 0L
        const val FLOAT = 0f
        const val DOUBLE = 0.0
        const val BOOLEAN = false
        val NULL = null
    }
}