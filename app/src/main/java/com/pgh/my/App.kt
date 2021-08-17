package com.pgh.my

import android.app.Application
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.pgh.my.db.AppDatabase
import com.pgh.my.di.appModule
import com.pgh.my.di.cityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidFileProperties
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application() {

    lateinit var database: AppDatabase


    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "database")
            .addMigrations(migration)
            .build()
        startKoin {
            androidLogger()
            androidContext(this@App)
            androidFileProperties()
            modules(appModule, cityModule)
        }
    }
    val migration = object : Migration(4, 5) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("UPDATE  'Weather' SET city = 'Питер' WHERE id=4")

        }
    }
}

