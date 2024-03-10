package com.example.foodapp.data.dataSource

import com.example.foodapp.data.entity.Foods
import com.example.foodapp.retrofit.FoodsDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class FoodsDataSource(var foodsDao: FoodsDao) {

}