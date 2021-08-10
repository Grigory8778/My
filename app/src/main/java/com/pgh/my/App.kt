package com.pgh.my

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application()  {

    lateinit var database: AppDatabase
//    val _weatherApi: WeatherApi by lazy {
//        NetworkComponent().weatherApi
//    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .addMigrations(mig, migration, migration3,migration4)
            .build()
        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            modules(appModule)
        }
    }

    val mig = object : Migration(1, 2) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("ALTER TABLE 'Weather' ADD COLUMN 'city' TEXT")
            database.execSQL("UPDATE  'Weather' SET city = 'Киев'")

        }
    }

    val migration = object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("UPDATE  'Weather' SET city = 'Москва' WHERE city = NULL")

        }
    }

    val migration3 = object : Migration(3, 4) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("UPDATE  'Weather' SET city = 'Москва' WHERE city == NULL")

        }
    }
    val migration4 = object : Migration(4, 5) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("UPDATE  'Weather' SET city = 'Питер' WHERE id=4")

        }
    }
}

