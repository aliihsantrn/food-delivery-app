package com.example.foodapp.ui.viewModel

import androidx.lifecycle.ViewModel
import com.example.foodapp.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(var repo : FoodsRepository) : ViewModel() {
}