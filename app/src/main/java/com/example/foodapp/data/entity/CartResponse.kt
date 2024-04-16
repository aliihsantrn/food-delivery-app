package com.example.foodapp.data.entity

import com.google.gson.annotations.SerializedName

data class CartResponse(
    val success : Int,
    @SerializedName("sepet_yemekler")
    val cart : List<CartFood>
)