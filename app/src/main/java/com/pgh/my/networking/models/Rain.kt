package com.pgh.my.networking.models

import com.google.gson.annotations.SerializedName

data class Rain(
    @SerializedName("1h")
    val oneHour: Double
)