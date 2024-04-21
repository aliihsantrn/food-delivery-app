package com.example.foodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.data.entity.CartFood
import com.example.foodapp.databinding.FragmentCartBinding
import com.example.foodapp.ui.adapter.CartAdapter
import com.example.foodapp.ui.viewModel.CartFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private lateinit var binding : FragmentCartBinding
    val viewModel : CartFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_cart , container , false)

        binding.totalCount = "0"

        viewModel.cartlist.observe(viewLifecycleOwner) {
            val cartAdapter = CartAdapter(requireContext() , it , viewModel)
            binding.cartAdapter = cartAdapter

            var count = it.sumOf { it.yemek_fiyat * it.yemek_siparis_adet }
            binding.totalCount = count.toString()
            binding.subtotal = (count + 10).toString()
            println(it)
        }

        binding.cartTopAppBar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }


    override fun onResume() {
        super.onResume()
        viewModel.getBasket()
    }
}