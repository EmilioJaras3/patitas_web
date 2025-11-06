package com.example.examen.datos

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Registro::class], version = 1)
abstract class AppDb : RoomDatabase() {
    abstract fun registroDao(): RegistroDao
}