package com.example.foodapp.ui.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater , container , false)

        appBarNavigation()

        binding.gelsin.setOnClickListener {
            showDialog(it , R.id.action_homeFragment_to_foodDetailsFragment)
        }

        return binding.root
    }

    private fun appBarNavigation() {
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.favoriteFragment -> {
                    findNavController().navigate(R.id.action_homeFragment_to_favoriteFragment)
                    true
                }
                R.id.cartFragment -> {
                    findNavController().navigate(R.id.action_homeFragment_to_cartFragment)
                    true
                }
                else -> false
            }
        }
    }

    private fun showDialog(it : View , id : Int) {
        Navigation.findNavController(it).navigate(id)
    }
}