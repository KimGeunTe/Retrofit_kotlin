package com.example.retrofit.VO

import com.google.gson.annotations.SerializedName

data class PhotoUrl(
    @SerializedName("full")  val full: String,
    @SerializedName("regular")  val regular: String
)
