package com.example.foodapp.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.foodapp.R
import com.example.foodapp.databinding.CustomAlertDialogBinding
import com.example.foodapp.databinding.FragmentFoodDetailsBinding
import com.example.foodapp.ui.viewModel.FoodDetailsFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodDetailsFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFoodDetailsBinding
    private lateinit var customAlertbinding : CustomAlertDialogBinding
    val viewModel: FoodDetailsFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_food_details, container, false)
        binding.nesne = this
        customAlertbinding = CustomAlertDialogBinding.inflate(layoutInflater)
        //veri gonder adapterdan
        val bundle: FoodDetailsFragmentArgs by navArgs()
        val food = bundle.food

        binding.sonuc = "1"
        binding.foodObject = food

        val url = "http://kasimadalan.pe.hu/yemekler/resimler/${food.yemek_resim_adi}"
        Glide.with(this).load(url).into(binding.foodDetailImage)

        var alertDialog: AlertDialog? = null
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(customAlertbinding.root)
        alertDialog = builder.create()
        customAlertbinding.textButton.setOnClickListener {
            alertDialog.cancel()
            this.onDestroyView()
        }


        binding.addtoCart.setOnClickListener {

            alertDialog?.show()
            println(
                viewModel.addToCart(
                    food.yemek_adi,
                    food.yemek_resim_adi,
                    food.yemek_fiyat.toInt(),
                    binding.sonuc!!.toInt()
                )
            )
        }

        return binding.root
    }

    fun add(num1: String) {
        val result = num1.toIntOrNull()?.plus(1) ?: return
        binding.sonuc = result.toString()
    }

    fun subtract(num1: String) {
        val result = (num1.toIntOrNull() ?: 1) - 1
        binding.sonuc = if (result < 1) "1" else result.toString()
    }

    fun strPicker(str1: String, str2: String): String {
        val num1 = str1.toIntOrNull()
        val num2 = str2.toIntOrNull()
        return (num2?.let { num1?.times(it) }).toString()
    }
}