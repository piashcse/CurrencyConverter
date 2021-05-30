package com.piashcse.currencyconverter.ui.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.piashcse.currencyconverter.data.repository.DataRepository
import com.piashcse.currencyconverter.utils.base.BaseActivity
import com.piashcse.currencyconverter.utils.constants.AppConstants
import com.piashcse.currencyconverter.utils.extension.jsonData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import java.sql.Time
import javax.inject.Inject

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
@HiltViewModel
class CurrencyViewModel @Inject constructor(private val repo: DataRepository) : ViewModel() {
    val currencyResponse = MutableLiveData<Map<String, String>>()
    val currencyConvertedResponse = MutableLiveData<Map<String, Double>>()
    fun currencyList(activity: BaseActivity) {
        viewModelScope.launch {
            activity.showProgress()
            try {
                val response = repo.currencyList()
                if (response.isSuccessful) {
                    activity.hideProgress()
                    val success = response.body()?.success ?: AppConstants.Default.BOOLEAN
                    if (success) {
                        currencyResponse.value = response.body()?.currencies
                    } else {
                        activity.showAlert(response.body()?.error?.info.toString())
                    }
                } else {
                    activity.hideProgress()
                    activity.showAlert(response.errorBody()?.jsonData().toString())

                }
            } catch (error: Throwable) {
                activity.hideProgress()
                activity.showAlert(error.toString())
            }
        }
    }

    fun currencyConvertedList(activity: BaseActivity, sourceCurrency: String) {
        viewModelScope.launch {
            activity.showProgress()
            try {
                val response = repo.currencyConvertedList(sourceCurrency)
                if (response.isSuccessful) {
                    activity.hideProgress()
                    val success = response.body()?.success ?: AppConstants.Default.BOOLEAN
                    if (success) {
                        currencyConvertedResponse.value = response.body()?.quotes
                    } else {
                        activity.showAlert(response.body()?.error?.info.toString())
                    }
                } else {
                    activity.hideProgress()
                    activity.showAlert(response.errorBody()?.jsonData().toString())

                }
            } catch (error: Throwable) {
                activity.hideProgress()
                activity.showAlert(error.toString())
            }
        }
    }
}