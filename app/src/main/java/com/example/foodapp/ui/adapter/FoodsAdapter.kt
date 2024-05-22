package com.example.foodapp.ui.adapter

import android.content.Context
import android.content.res.Resources.Theme
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.data.entity.CartFood
import com.example.foodapp.data.entity.Foods
import com.example.foodapp.data.repo.FoodsRepository
import com.example.foodapp.databinding.CardDesignBinding
import com.example.foodapp.databinding.CustomToastMsgBinding
import com.example.foodapp.ui.fragment.HomeFragmentDirections
import com.example.foodapp.ui.viewModel.HomeFragmentViewModel
import com.example.foodapp.util.AppConstants
import com.example.foodapp.util.sendToPage
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FoodsAdapter(
    var context: Context,
    var foodList: List<Foods>,
    var viewModel: HomeFragmentViewModel
) : RecyclerView.Adapter<FoodsAdapter.FoodsHolder>() {
    inner class FoodsHolder(
        var binding: CardDesignBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodsHolder {
        val binding : CardDesignBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context) ,
            R.layout.card_design , parent ,false)

        binding.adapterObject = this

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

        Glide.with(context)
            .load(url)
            .override(200 , 150)
            .into(design.foodImageView)

        design.foodCardView.setOnClickListener {
            //detay sayfasına veri gönder
            val gecis = HomeFragmentDirections.actionHomeFragmentToFoodDetailFragment(food)
            Navigation.findNavController(it).navigate(gecis)
        }

        design.button.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                viewModel.addToCart(
                    food.yemek_adi,
                    food.yemek_resim_adi,
                    food.yemek_fiyat.toInt(),
                    1
                )
            }

            val inflater: LayoutInflater = LayoutInflater.from(context)
            val toastMsgBinding : CustomToastMsgBinding = CustomToastMsgBinding.inflate(inflater)
            val rootView = toastMsgBinding.root

            toastMsgBinding.toastMsgText.text = "Added to Cart"

            val toast = Toast(it.context)
            toast.duration = Toast.LENGTH_SHORT
            toast.view = rootView
            toast.show()
        }
    }



}