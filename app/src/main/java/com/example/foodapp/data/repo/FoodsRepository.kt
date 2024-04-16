package com.example.foodapp.data.repo

import com.example.foodapp.data.dataSource.FoodsDataSource
import com.example.foodapp.data.entity.CartFood
import com.example.foodapp.data.entity.Foods

class FoodsRepository(var dataSource: FoodsDataSource) {

    suspend fun loadFoods() : List<Foods> = dataSource.loadFoods()

    suspend fun addtoBasket(
        foodName : String,
        foodImage : String,
        foodPrice : Int,
        foodPiece : Int,
        userName : String
    ) = dataSource.AddtoBasket(foodName, foodImage, foodPrice, foodPiece, userName)

    suspend fun getBasket() : List<CartFood> = dataSource.getBasket()

    suspend fun deleteFood(foodId : Int) = dataSource.deleteFood(foodId)
}