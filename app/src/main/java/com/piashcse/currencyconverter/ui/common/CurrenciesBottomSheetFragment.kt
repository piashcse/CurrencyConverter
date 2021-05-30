package com.piashcse.currencyconverter.ui.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.piashcse.currencyconverter.data.models.Currency
import com.piashcse.currencyconverter.databinding.FragmentCurrenciesBottomSheetBinding
import com.piashcse.currencyconverter.ui.adapter.CurrencyAdapter
import com.piashcse.currencyconverter.ui.vm.CurrencyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.piashcse.currencyconverter.data.datasource.local.AppDatabase

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
@AndroidEntryPoint
class CurrenciesBottomSheetFragment(val currencies:List<Currency>, val callBack: (currency: Currency) -> Unit) :
    BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCurrenciesBottomSheetBinding
    private val viewModel: CurrencyViewModel by viewModels()
    private lateinit var currencyAdapter: CurrencyAdapter
    @Inject
    lateinit var dataBase: AppDatabase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCurrenciesBottomSheetBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        currencyAdapter = CurrencyAdapter()
        binding.recyclerCurrency.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = currencyAdapter
        }
        currencyAdapter.updateItems(currencies)
        currencyAdapter.onItemClick = {
            callBack.invoke(it)
            dismiss()
        }
    }

}