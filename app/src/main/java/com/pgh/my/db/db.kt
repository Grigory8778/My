package com.pgh.my.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Weather::class], version = 5)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}

