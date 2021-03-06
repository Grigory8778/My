package com.pgh.my.networking.models

import com.google.gson.annotations.SerializedName

data class ListElement (
    @SerializedName("main")
    val main: MainAqi,
    @SerializedName("components")
    val components: Map<String, Double>,
    @SerializedName("dt")
    val dt: Long
)