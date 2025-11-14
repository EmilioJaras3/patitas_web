package com.example.wellnessapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wellnessapp.data.local.dao.FavoriteRoutineDao
import com.example.wellnessapp.data.local.entity.FavoriteRoutineEntity

@Database(
    entities = [FavoriteRoutineEntity::class],
    version = 1,
    exportSchema = false
)
abstract class WellnessDatabase : RoomDatabase() {
    abstract fun favoriteRoutineDao(): FavoriteRoutineDao
}