package com.pgh.my

import com.google.gson.annotations.SerializedName


data class PollutionResponse (
    @SerializedName("coord")
    val coord: Coord,
    @SerializedName("list")
    val list: List<ListElement>
)

data class Coord (
    @SerializedName("lon")
    val lon: Double,
    @SerializedName("lat")
    val lat: Double
)

data class ListElement (
    @SerializedName("main")
    val main: Main,
    @SerializedName("components")
    val components: Map<String, Double>,
    @SerializedName("dt")
    val dt: Long
)

data class Main (
    @SerializedName("aqi")
    val aqi: Long
)
