package com.pgh.my.db

import androidx.room.*

@Dao
interface WeatherDao {
    @Query("SELECT * FROM weather")
    suspend fun all(): List<Weather>

    @Insert
    fun insert(weather: Weather)

    @Query("SELECT * FROM weather WHERE id =:id")
    suspend fun getByID(id: Long): Weather

    @Update()
    fun update(weather: Weather)

    @Delete
    fun delete(weather: Weather)
}