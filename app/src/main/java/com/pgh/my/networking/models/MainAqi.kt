package com.pgh.my.networking.models

import com.google.gson.annotations.SerializedName

data class MainAqi (
    @SerializedName("aqi")
    val aqi: Long
)