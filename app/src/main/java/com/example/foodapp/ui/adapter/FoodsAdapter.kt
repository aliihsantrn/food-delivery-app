package com.example.foodapp.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.databinding.CardDesignBinding

class FoodsAdapter() : RecyclerView.Adapter<FoodsAdapter.FoodsHolder>() {
    inner class FoodsHolder(var binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: FoodsHolder, position: Int) {
        TODO("Not yet implemented")
    }
}