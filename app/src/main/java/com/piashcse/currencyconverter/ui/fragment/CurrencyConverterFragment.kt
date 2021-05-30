package com.piashcse.currencyconverter.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import com.piashcse.currencyconverter.data.datasource.local.AppDatabase
import com.piashcse.currencyconverter.data.datasource.local.DataStoreManager
import com.piashcse.currencyconverter.data.models.ConvertedCurrency
import com.piashcse.currencyconverter.data.models.Currency
import com.piashcse.currencyconverter.data.models.list.Currencies
import com.piashcse.currencyconverter.databinding.FragmentCurrencyConverterBinding
import com.piashcse.currencyconverter.ui.common.ConvertedCurrenciesBottomSheetFragment
import com.piashcse.currencyconverter.ui.common.CurrenciesBottomSheetFragment
import com.piashcse.currencyconverter.ui.vm.CurrencyViewModel
import com.piashcse.currencyconverter.utils.extension.baseActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject
import kotlin.reflect.full.memberProperties

/**
 * Created by Piash on 5/29/21
 * Copyright (c) 2021 Mehedi Hassan Piash. All rights reserved.
 * piash599@gmail.com
 */
@AndroidEntryPoint
class CurrencyConverterFragment : Fragment() {
    private lateinit var binding: FragmentCurrencyConverterBinding
    private val viewModel: CurrencyViewModel by viewModels()
    private var sourceCurrency = 1.0
    private var convertedCurrency = 1.0

    @Inject
    lateinit var dataBase: AppDatabase

    @Inject
    lateinit var dataStore: DataStoreManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCurrencyConverterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        apiResponse()
    }

    private fun initView() {
        lifecycleScope.launch {
            dataStore.getBooleanData(DataStoreManager.IS_FIRST_TIME).asLiveData()
                .observe(viewLifecycleOwner) {
                    it?.let {
                        if (it.not()) {
                            viewModel.currencyList(requireActivity().baseActivity())
                        }
                    }
                }
        }
        binding.baseCurrency.setOnClickListener {
            lifecycleScope.launch {
                dataBase.currencyDao().getAll().asLiveData().observe(viewLifecycleOwner) {
                    it?.let {
                        if (it.isNotEmpty()) {
                            CurrenciesBottomSheetFragment(it) { item ->
                                binding.baseCurrency.text = item.currency
                                viewModel.currencyConvertedList(
                                    requireActivity().baseActivity(),
                                    item.currency
                                )

                            }.show(
                                requireActivity().supportFragmentManager,
                                CurrenciesBottomSheetFragment::class.java.name
                            )
                        }
                    }
                }
            }
        }

        binding.convertedCurrency.setOnClickListener {
            lifecycleScope.launch {
                dataBase.convertedCurrencyDao().getAll().asLiveData().observe(viewLifecycleOwner) {
                    it?.let {
                        if (it.isNotEmpty()) {
                            ConvertedCurrenciesBottomSheetFragment(it) { item ->
                                binding.convertedCurrency.text = item.convertedCurrency
                                convertedCurrency = item.currencyRate
                                binding.convertedAmount.text =
                                    String.format("%.1f", sourceCurrency * item.currencyRate)
                            }.show(
                                requireActivity().supportFragmentManager,
                                CurrenciesBottomSheetFragment::class.java.name
                            )
                        }
                    }
                }
            }
        }

        binding.baseAmount.doOnTextChanged { text, _, _, _ ->
            text?.let {
                if (it.trim().isNotEmpty()) {
                    sourceCurrency = text.toString().toDouble()
                    val base = text.toString().toDouble() * convertedCurrency
                    binding.convertedAmount.text = String.format("%.1f", base)
                }
            }
        }
    }

    private fun apiResponse() {
        viewModel.currencyResponse.observe(viewLifecycleOwner) {
            it?.let {
                val data = arrayListOf<Currency>()
                it.forEach { (key, value) ->
                    data.add(Currency(0, key.uppercase(), value))
                }
                lifecycleScope.launch {
                    dataStore.storeBooleanData(DataStoreManager.IS_FIRST_TIME, true)
                }
                storeCurrencies(data)
            }
        }
        viewModel.currencyConvertedResponse.observe(viewLifecycleOwner) {
            it?.let {
                val data = arrayListOf<ConvertedCurrency>()
                it.forEach { (key, value) ->
                    data.add(ConvertedCurrency(0, key.uppercase(), value))
                }
                lifecycleScope.launch {
                    dataBase.convertedCurrencyDao().insertAll(data)
                }
            }
        }
    }

    private fun storeCurrencies(currencies: ArrayList<Currency>) {
        lifecycleScope.launch {
            dataBase.currencyDao().insertAll(currencies)
        }
    }
}