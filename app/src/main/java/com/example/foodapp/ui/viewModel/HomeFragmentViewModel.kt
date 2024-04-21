package com.example.foodapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodapp.data.entity.Foods
import com.example.foodapp.data.repo.FoodsRepository
import com.example.foodapp.util.AppConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
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

    fun addToCart(
        foodName : String,
        foodImage : String,
        foodPrice : Int,
        foodPiece : Int
    ) {
        CoroutineScope(Dispatchers.Main).launch {
            repo.addtoBasket(foodName , foodImage , foodPrice , foodPiece)
        }
    }
}