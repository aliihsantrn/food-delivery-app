package com.example.foodapp.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.bumptech.glide.Glide

fun Navigation.sendToPage(it : View, id : Int) {
    findNavController(it).navigate(id)
}

fun Navigation.sendToPage(it: View , id : NavDirections) {
    findNavController(it).navigate(id)
}
