package com.pgh.my.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Weather(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    var name: String? = null,
    var city: String? = null
)