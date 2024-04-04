package com.example.foodapp.data.dataSource

import com.example.foodapp.data.entity.CRUDResponse
import com.example.foodapp.data.entity.Foods
import com.example.foodapp.retrofit.FoodsDao
import com.example.foodapp.util.AppConstants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDataSource(var foodsDao: FoodsDao) {
    suspend fun loadFoods() : List<Foods> =
        withContext(Dispatchers.IO) {
            return@withContext foodsDao.getFoods().yemekler
        }

    suspend fun AddtoBasket(
        foodName : String,
        foodImage : String,
        foodPrice : Int,
        foodPiece : Int,
        userName : String) =
        withContext(Dispatchers.IO) {
            return@withContext foodsDao.addtoBasket(
                foodName,
                foodImage,
                foodPrice,
                foodPiece,
                userName
            )
        }

    suspend fun getBasket() =
        withContext(Dispatchers.IO) {
            try {
                if (foodsDao.getBasket(AppConstants.USERNAME).cart == null) {
                    return@withContext emptyList()
                }

                return@withContext foodsDao.getBasket(AppConstants.USERNAME).cart

            } catch (e : Exception) {
                return@withContext emptyList()
            }

        }
}