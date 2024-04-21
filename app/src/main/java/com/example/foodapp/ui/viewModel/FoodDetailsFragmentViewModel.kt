package com.example.foodapp.ui.viewModel

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.repo.FoodsRepository
import com.example.foodapp.util.AppConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FoodDetailsFragmentViewModel
@Inject constructor(var repo : FoodsRepository) : ViewModel() {

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