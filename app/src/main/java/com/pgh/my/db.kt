package com.pgh.my

import androidx.room.*


@Entity
data class Weather(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String? = null,
    var city: String? = null

)

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
@Database(entities = [Weather::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

}

