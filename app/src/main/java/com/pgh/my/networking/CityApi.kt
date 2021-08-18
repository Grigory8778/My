package com.pgh.my.networking

import com.pgh.my.di.API_NEARBY_CITIES
import retrofit2.http.GET
import retrofit2.http.Query

interface CityApi {
    @GET(API_NEARBY_CITIES)
    suspend fun getInfoCity(
        @Query("radius") radius: Int,
        @Query("limit") limit: Int,
        @Query("latitude") latitude: Double,
        @Query("longitude") longitude: Double,
    ): Array<Array<String>>
}