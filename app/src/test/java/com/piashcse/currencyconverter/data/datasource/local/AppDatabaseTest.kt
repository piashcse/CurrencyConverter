package com.piashcse.currencyconverter.data.datasource.local

import android.content.Context
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.asLiveData
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.piashcse.currencyconverter.data.models.Currency
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.mock


/**
 * Created by Piash on 5/30/21
 * Copyright (c) 2021 bjit. All rights reserved.
 * piash.hassan@bjitgroup.com
 * Last modified 5/30/21
 */
@RunWith(AndroidJUnit4::class)
class AppDatabaseTest : TestCase() {
    private lateinit var db: AppDatabase
    private lateinit var dao: CurrencyDao
    private var mOwner: LifecycleOwner? = null
    private var mLifecycle: Lifecycle? = null

    @Before
    override fun setUp() {
        val context: Context = ApplicationProvider.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase::class.java).build()
        dao = db.currencyDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Before
    fun initMocks() {
        mOwner = mock(LifecycleOwner::class.java)
        mLifecycle = mock(Lifecycle::class.java)
    }

    @Test
    fun writeAndReadDatabase() = runBlocking {
        val currency = Currency(0, "BDT", "Bangladesh")
        dao.insertAll(listOf(currency))
        mOwner?.let {
            db.currencyDao().getAll().asLiveData().observe(it) { list ->
                assertTrue(list.isNotEmpty())
            }
        }
    }
}