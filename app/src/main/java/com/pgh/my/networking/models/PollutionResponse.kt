package com.pgh.my.networking.models

import com.google.gson.annotations.SerializedName

data class PollutionResponse (
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("list")
    val list: List<ListElement>
)