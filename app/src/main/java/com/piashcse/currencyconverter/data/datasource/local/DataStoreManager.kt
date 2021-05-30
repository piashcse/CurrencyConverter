package com.piashcse.currencyconverter.data.datasource.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

/**
 * Created by Piash on 5/29/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
class DataStoreManager(var context: Context) {
    // Create the dataStore and give it a name same as shared preferences
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("pay_pay")
    val dataStore: DataStore<Preferences> = context.dataStore

    // Create some keys we will use them to store and retrieve the data
    companion object {
        val IS_FIRST_TIME = booleanPreferencesKey("is_first_time") // String key
    }


    // store data as object
    suspend fun <T> storeObjectData(key: Preferences.Key<String>, value: T) {
        dataStore.edit { preferences ->
            preferences[key] = serializeData(value)
        }
    }

    // store data as object
    suspend fun storeObjectRemoveData(key: Preferences.Key<String>) {
        dataStore.edit { preferences ->
           preferences.remove(key)
        }
    }

    // save primitives data
    suspend fun storeStringData(key: Preferences.Key<String>, value: String) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun storeIntData(key: Preferences.Key<Int>, value: Int) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun storeDoubleData(key: Preferences.Key<Double>, value: Double) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun storeDoubleData(key: Preferences.Key<Float>, value: Float) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun storeLongData(key: Preferences.Key<Long>, value: Long) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    suspend fun storeBooleanData(key: Preferences.Key<Boolean>, value: Boolean) {
        dataStore.edit { preferences ->
            preferences[key] = value
        }
    }

    // Create a flow to retrieve data from the preferences
    // flow comes from the kotlin coroutine

    // get data as object
    inline fun <reified T> getObjectData(key: Preferences.Key<String>): Flow<T> =
        dataStore.data.map {
            deSerializeData(it[key] ?: "")
        }

    // get primitives data
    fun getStringData(key: Preferences.Key<String>): Flow<String> = dataStore.data.map {
        it[key] ?: ""
    }

    fun getIntData(key: Preferences.Key<Int>): Flow<Int> = dataStore.data.map {
        it[key] ?: 0
    }

    fun getDoubleData(key: Preferences.Key<Double>): Flow<Double> = dataStore.data.map {
        it[key] ?: 0.0
    }

    fun getFloatData(key: Preferences.Key<Float>): Flow<Float> = dataStore.data.map {
        it[key] ?: 0.0f
    }

    fun getLongData(key: Preferences.Key<Long>): Flow<Long> = dataStore.data.map {
        it[key] ?: 0
    }

    fun getBooleanData(key: Preferences.Key<Boolean>): Flow<Boolean> = dataStore.data.map {
        it[key] ?: false
    }

    // remove data


    private fun <T> serializeData(data: T): String {
        return Gson().toJson(data)
    }

    inline fun <reified T> deSerializeData(data: String): T {
        return Gson().fromJson(data, T::class.java)
    }
}