package com.example.examen.datos

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "registros")
data class Registro(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val nombre: String,
    val pokemonFav: String
)