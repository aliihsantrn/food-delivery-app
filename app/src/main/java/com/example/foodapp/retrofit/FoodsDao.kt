package com.example.foodapp.retrofit

import com.example.foodapp.data.entity.CRUDResponse
import com.example.foodapp.data.entity.CartResponse
import com.example.foodapp.data.entity.Foods
import com.example.foodapp.data.entity.FoodsResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface FoodsDao {
    // http://kasimadalan.pe.hu/yemekler/tumYemekleriGetir.php
    // http://kasimadalan.pe.hu/ -> base url
    // yemekler/tumYemekleriGetir.php -> web service

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getFoods() : FoodsResponse

    @POST("yemekler/sepeteYemekEkle.php")
    @FormUrlEncoded
    suspend fun addtoBasket(
        @Field("yemek_adi") foodName : String,
        @Field("yemek_resim_adi") foodImage : String,
        @Field("yemek_fiyat") foodPrice : Int,
        @Field("yemek_siparis_adet") foodPiece : Int,
        @Field("kullanici_adi") userName : String
    ) : CRUDResponse

    @POST("yemekler/sepettekiYemekleriGetir.php")
    @FormUrlEncoded
    suspend fun getBasket(
        @Field("kullanici_adi") userName : String
    ) : CartResponse

    @POST("yemekler/sepettenYemekSil.php")
    @FormUrlEncoded
    suspend fun deleteFoodFromCart(
        @Field("sepet_yemek_id") cartFoodId: Int,
        @Field("kullanici_adi") username: String
    ): CRUDResponse



}