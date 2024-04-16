package com.example.foodapp.data.entity

import java.io.Serializable

data class Foods(
    val yemek_adi: String,
    val yemek_fiyat: String,
    val yemek_id: String,
    val yemek_resim_adi: String
) : Serializable