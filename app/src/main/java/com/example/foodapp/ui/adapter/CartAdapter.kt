package com.example.foodapp.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.data.entity.CartFood
import com.example.foodapp.databinding.CartCardDesignBinding
import com.example.foodapp.ui.viewModel.CartFragmentViewModel
import com.google.android.material.color.MaterialColors
import com.google.android.material.snackbar.Snackbar

class CartAdapter(
    var context: Context,
    var cartList: List<CartFood>,
    var viewModel: CartFragmentViewModel) : RecyclerView.Adapter<CartAdapter.CartsHolder>() {
    inner class CartsHolder(
        var binding: CartCardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int): CartAdapter.CartsHolder {

        val binding : CartCardDesignBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.cart_card_design,
            parent,
            false
        )

        return CartsHolder(binding)
    }

    override fun getItemCount(): Int {
        return cartList.size
    }

    override fun onBindViewHolder(holder: CartAdapter.CartsHolder, position: Int) {

        val cartFood = cartList.get(position)
        val design = holder.binding

        design.cartFoodObject = cartFood

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${cartFood.yemek_resim_adi}"

        Glide.with(context)
            .load(url)
            .override(200 , 150)
            .into(design.foodImageView)

        design.DeleteBtn.setOnClickListener {
            val message = "${cartFood.yemek_adi} sepetten çıkarılsın mı?"
            Snackbar.make(it, message, Snackbar.LENGTH_LONG)
                .setBackgroundTint(Color.WHITE)
                .setActionTextColor(Color.RED)
                .setTextColor(Color.RED)
                .setAction("EVET") {

                    viewModel.deleteFood(cartFood.sepet_yemek_id)
                    viewModel.getBasket()
                }.show()
        }

    }

}