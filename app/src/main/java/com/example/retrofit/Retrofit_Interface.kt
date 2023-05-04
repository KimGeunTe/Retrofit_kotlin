package com.example.retrofit

import com.example.retrofit.VO.PhotoVO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Retrofit_Interface {
    @GET("photos/?client_id=BMTLDQkgDmm0o6F8KuErdlr04Prg2O_WAsAZebqvIIU")
    fun getPhoto(
        @Query("page") page:Int,
        @Query("per_page") perPage:Int,
        @Query("order_by") oederBy:String
    ): Call<MutableList<PhotoVO>>

}