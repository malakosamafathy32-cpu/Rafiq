package com.example.rafiq.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [EquippedPlaceEntity::class],
    version = 1,
    exportSchema = false
)
abstract class RafiqDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao
}
