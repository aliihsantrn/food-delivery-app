package com.example.foodapp.ui.fragment

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.foodapp.R
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.ui.adapter.FoodsAdapter
import com.example.foodapp.ui.viewModel.HomeFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    val viewModel : HomeFragmentViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater , R.layout.fragment_home , container , false)

        viewModel.foodList.observe(viewLifecycleOwner) {
            val foodsAdapter = FoodsAdapter(requireContext() ,it , viewModel)
            binding.foodsAdapter = foodsAdapter
        }


        appBarNavigation()

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


}