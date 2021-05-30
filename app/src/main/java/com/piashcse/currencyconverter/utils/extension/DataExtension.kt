package com.piashcse.currencyconverter.utils.extension

import com.piashcse.currencyconverter.ui.common.CurrenciesBottomSheetFragment
import okhttp3.ResponseBody
import org.json.JSONObject

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */

fun ResponseBody.jsonData(): JSONObject {
    return JSONObject(this.string())
}

inline fun <T : Any, R> T?.ifNotNullOrElse(ifNotNullPath: (T) -> R, elsePath: () -> R) =
    let { if (it == null) elsePath() else ifNotNullPath(it) }
