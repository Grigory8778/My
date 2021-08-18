package com.pgh.my.networking.models

import com.google.gson.annotations.SerializedName

data class City(
    @SerializedName("0")
    val bearing: Double,
    @SerializedName("1")
    val cityName: String,
    @SerializedName("2")
    val region: String,
    @SerializedName("3")
    val countryName: String,
    @SerializedName("4")
    val direction: String,
    @SerializedName("5")
    val nauticalMiles: Double,
    @SerializedName("6")
    val internetCode: String,
    @SerializedName("7")
    val kilometres: Double,
    @SerializedName("8")
    val latitude: Double,
    @SerializedName("9")
    val geobytes: String,
    @SerializedName("10")
    val longitude: Double,
    @SerializedName("11")
    val miles: Double,
    @SerializedName("12")
    val regionState: String
    )