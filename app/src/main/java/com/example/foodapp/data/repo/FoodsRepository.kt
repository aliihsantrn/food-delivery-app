package com.example.foodapp.data.repo

import com.example.foodapp.data.dataSource.FoodsDataSource
import com.example.foodapp.data.entity.Foods

class FoodsRepository(var dataSource: FoodsDataSource) {

    suspend fun loadFoods() : List<Foods> = dataSource.loadFoods()
}