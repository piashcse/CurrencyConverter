package com.piashcse.currencyconverter.ui

import android.os.Bundle
import com.piashcse.currencyconverter.databinding.ActivityMainBinding
import com.piashcse.currencyconverter.utils.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}