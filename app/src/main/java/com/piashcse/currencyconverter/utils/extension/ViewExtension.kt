package com.piashcse.currencyconverter.utils.extension

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.View
import android.widget.Toast
import com.piashcse.currencyconverter.utils.base.BaseActivity

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
fun View.hide() {
    this.visibility = View.GONE
}

fun View.show() {
    this.visibility = View.VISIBLE
}

fun Context.showToast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Int.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun Int.pixelToDp(): Int {
    return (this / Resources.getSystem().displayMetrics.density).toInt()
}

fun Activity.baseActivity(): BaseActivity {
    return this as BaseActivity
}
