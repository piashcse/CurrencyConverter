package com.piashcse.currencyconverter.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.piashcse.currencyconverter.data.models.Currency
import com.piashcse.currencyconverter.databinding.AdapterCurrencyItemBinding

/**
 * Created by Piash on 5/22/21
 * Copyright (c) 2021 bjit. All rights reserved.
 * piash.hassan@bjitgroup.com
 * Last modified 5/22/21
 */
class CurrencyAdapter : RecyclerView.Adapter<CurrencyAdapter.HomeViewHolder>() {
    private var items: ArrayList<Currency> = arrayListOf()
    var onItemClick: ((Currency) -> Unit)? = null

    fun updateItems(newItems: List<Currency>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class HomeViewHolder(private val binding: AdapterCurrencyItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Currency) {
            binding.currency = item
            binding.executePendingBindings()
            itemView.setOnClickListener { onItemClick?.invoke(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val binding = AdapterCurrencyItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = items[position]
        return holder.bind(item)
    }

    override fun getItemCount() = items.size
}