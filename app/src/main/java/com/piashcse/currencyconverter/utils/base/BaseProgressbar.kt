package com.piashcse.currencyconverter.utils.base

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Build
import com.piashcse.currencyconverter.R

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
class BaseProgressbar {
    private lateinit var dialog: CustomDialog
    fun show(context: Context): Dialog {
        val inflater = (context as Activity).layoutInflater
        val view = inflater.inflate(R.layout.progress_dialog_view, null)

        if (::dialog.isInitialized.not()) {
            dialog = CustomDialog(context)
            dialog.setContentView(view)
            dialog.setCancelable(false)
        }
        dialog.show()
        return dialog
    }

    fun hide() {
        dialog.dismiss()
    }

    class CustomDialog(context: Context) : Dialog(context, R.style.ProgressBarTheme) {
        init {
            // Set Semi-Transparent Color for Dialog Background
            window?.decorView?.rootView?.setBackgroundResource(R.color.black_alpha_30)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT_WATCH) {
                window?.decorView?.setOnApplyWindowInsetsListener { _, insets ->
                    insets.consumeSystemWindowInsets()
                }
            }
        }
    }
}