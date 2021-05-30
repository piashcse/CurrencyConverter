package com.piashcse.currencyconverter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.piashcse.currencyconverter.data.models.ConvertedCurrency
import com.piashcse.currencyconverter.data.models.Currency
import com.piashcse.currencyconverter.databinding.AdapterConvertedCurrencyItemBinding
import com.piashcse.currencyconverter.databinding.AdapterCurrencyItemBinding

/**
 * Created by Piash on 5/29/21
 * Copyright (c) 2021 bjit. All rights reserved.
 * piash.hassan@bjitgroup.com
 * Last modified 5/22/21
 */
class ConvertedCurrencyAdapter : RecyclerView.Adapter<ConvertedCurrencyAdapter.HomeViewHolder>() {
    private var items: ArrayList<ConvertedCurrency> = arrayListOf()
    var onItemClick: ((ConvertedCurrency) -> Unit)? = null

    fun updateItems(newItems: List<ConvertedCurrency>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: AdapterConvertedCurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ConvertedCurrency) {
            binding.currency = item
            binding.executePendingBindings()
            itemView.setOnClickListener { onItemClick?.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = AdapterConvertedCurrencyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = items[position]
        return holder.bind(item)
    }

    override fun getItemCount() = items.size
}