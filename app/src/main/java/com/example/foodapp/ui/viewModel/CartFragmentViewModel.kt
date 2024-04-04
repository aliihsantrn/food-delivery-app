package com.example.foodapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.entity.CartFood
import com.example.foodapp.data.repo.FoodsRepository
import com.example.foodapp.util.AppConstants
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartFragmentViewModel
@Inject constructor(var repo : FoodsRepository) : ViewModel() {

    var cartlist = MutableLiveData<List<CartFood>>()

    init {
        getBasket()
    }
    fun getBasket() {
        CoroutineScope(Dispatchers.Main).launch {
            cartlist.value = repo.getBasket()
        }
    }
}