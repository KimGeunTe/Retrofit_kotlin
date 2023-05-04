package com.example.retrofit.VO

import com.google.gson.annotations.SerializedName

data class Exif(
    @SerializedName("make")  val make: String,
    @SerializedName("model")  val model: String,
    @SerializedName("exposure_time")  val exposure: String,
    @SerializedName("aperture")  val aperture: String,
    @SerializedName("focal_length")  val focal: String,
    @SerializedName("iso")  val iso: String
)
