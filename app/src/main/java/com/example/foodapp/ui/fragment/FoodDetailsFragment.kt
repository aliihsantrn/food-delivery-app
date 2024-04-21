package com.example.foodapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentFoodDetailsBinding
import com.example.foodapp.ui.viewModel.FoodDetailsFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailsFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFoodDetailsBinding
    val viewModel : FoodDetailsFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_food_details , container , false)
        binding.nesne = this
        //veri gonder adapterdan
        val bundle:FoodDetailsFragmentArgs by navArgs()
        val food = bundle.food

        binding.sonuc = "1"
        binding.foodObject = food

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(this).load(url).into(binding.foodDetailImage)

        binding.addtoCart.setOnClickListener {
            println(viewModel.addToCart(
                food.yemek_adi,
                food.yemek_resim_adi,
                food.yemek_fiyat.toInt(),
                binding.sonuc!!.toInt()
            ))
        }

        return binding.root
    }

    fun topla(sayi1 : String){
        var result = sayi1.toInt() + 1

        binding.sonuc = result.toString()
    }

    fun cıkar(sayi1 : String ){
        var result = sayi1.toInt() - 1

        if (result < 1){
            result = 1
        }

        binding.sonuc = result.toString()
    }

}