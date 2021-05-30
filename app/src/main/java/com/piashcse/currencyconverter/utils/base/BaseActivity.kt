package com.piashcse.currencyconverter.utils.base

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.piashcse.currencyconverter.R

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
abstract class BaseActivity : AppCompatActivity() {
    private val progressDialog: BaseProgressbar by lazy {
        BaseProgressbar()
    }
    private lateinit var alertDialog: Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        alertDialog = AlertDialog.Builder(this).setCancelable(false)
            .setMessage(R.string.network_is_not_available).create()
    }


    open fun showProgress() {
        progressDialog.show(this)
    }

    open fun hideProgress() {
        progressDialog.hide()
    }

    open fun showAlert(error: String) {
        BaseAlert(this).setTitleAndDescription(
            getString(R.string.error),
            error,
            getString(R.string.ok)
        ) {

        }
    }
}