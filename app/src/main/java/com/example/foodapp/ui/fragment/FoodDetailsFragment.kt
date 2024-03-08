package com.example.foodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentFoodDetailsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class FoodDetailsFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentFoodDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentFoodDetailsBinding.inflate(inflater , container , false)

        return binding.root
    }

}