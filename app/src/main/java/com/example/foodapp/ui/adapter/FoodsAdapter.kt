package com.example.foodapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.data.entity.Foods
import com.example.foodapp.databinding.CardDesignBinding
import com.example.foodapp.util.sendToPage

class FoodsAdapter(var context: Context , var foodList: List<Foods>) : RecyclerView.Adapter<FoodsAdapter.FoodsHolder>() {
    inner class FoodsHolder(var binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsHolder {
        val binding : CardDesignBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context) ,
            R.layout.card_design , parent ,false)

        return FoodsHolder(binding)
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    override fun onBindViewHolder(holder: FoodsHolder, position: Int) {
        val food = foodList.get(position)
        val design = holder.binding

        design.foodObject = food

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(context).load(url).override(200 , 150).into(design.imageView)

        design.foodCardView.setOnClickListener {
            Navigation.sendToPage(it ,R.id.action_homeFragment_to_foodDetailsFragment)
        }

    }
}