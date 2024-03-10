package com.example.foodapp.retrofit

import com.example.foodapp.data.entity.FoodsResponse
import retrofit2.http.GET

interface FoodsDao {
    // http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    // http://kasimadalan.pe.hu/ -> base url
    // yemekler/tumYemekleriGetir.php -> web service

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getFoods() : FoodsResponse
}