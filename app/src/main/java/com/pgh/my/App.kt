package com.pgh.my

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pgh.my.networking.NetworkComponent
import com.pgh.my.networking.WeatherApi
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(), SingletonsProvider {
    lateinit var database: AppDatabase
    private val singletonsHolder = HashMap<Any, Any>()
//    val _weatherApi: WeatherApi by lazy {
//        NetworkComponent().weatherApi
//    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .addMigrations(mig, migration, migration3,migration4)
            .build()
        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(appModule )
        }
    }

    override fun getWeatherApi(): WeatherApi {

        if (singletonsHolder[WeatherApi::class.java.simpleName] == null) {
            singletonsHolder[WeatherApi::class.java.simpleName] = NetworkComponent().weatherApi
        }
        return singletonsHolder[WeatherApi::class.java.simpleName] as WeatherApi
//        return _weatherApi
    }

    companion object {
        lateinit var instance: App
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

