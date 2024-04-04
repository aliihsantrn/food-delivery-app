package com.example.foodapp.data.entity

data class CartResponse(
    val success : Int,
    val cart : List<CartFood>
)