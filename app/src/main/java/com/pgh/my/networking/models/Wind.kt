package com.pgh.my.networking.models

import com.google.gson.annotations.SerializedName

data class Wind(
    @SerializedName("speed")
    val speed: Double,
    @SerializedName("deg")
    val deg: Double,
    @SerializedName("gust")
    val gust: Double
)