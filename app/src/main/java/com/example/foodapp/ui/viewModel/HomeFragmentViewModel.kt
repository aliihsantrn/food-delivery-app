package com.example.foodapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.entity.Foods
import com.example.foodapp.data.repo.FoodsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(var repo : FoodsRepository) : ViewModel() {

    var foodList = MutableLiveData<List<Foods>>()

    init {
        loadFoods()
    }

    private fun loadFoods() {
        CoroutineScope(Dispatchers.Main).launch {
            foodList.value = repo.loadFoods()
        }
    }
}