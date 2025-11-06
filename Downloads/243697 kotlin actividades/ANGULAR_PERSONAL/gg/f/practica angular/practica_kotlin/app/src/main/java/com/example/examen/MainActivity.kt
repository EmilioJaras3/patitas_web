package com.example.examen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.examen.datos.AppDb
import com.example.examen.datos.Registro
import com.example.examen.datos.RegistroDao
import com.example.examen.pantallas.*
import com.example.examen.ui.theme.ExamenTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private var pantallaActual = mutableStateOf("inicio")
    private var modoOscuro = mutableStateOf(false)
    private lateinit var baseDatos: AppDb
    private lateinit var registroDao: RegistroDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        baseDatos = Room.databaseBuilder(applicationContext, AppDb::class.java, "app.db").build()
        registroDao = baseDatos.registroDao()
        setContent {
            ExamenTheme(darkTheme = modoOscuro.value) {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    when (pantallaActual.value) {
                        "inicio" -> PantallaPrincipal(
                            irATema = { pantallaActual.value = "tema" },
                            irAFormulario = { pantallaActual.value = "formulario" }
                        )
                        "tema" -> PantallaTema(
                            modoOscuro = modoOscuro.value,
                            cambiarTema = { nuevoModo ->
                                modoOscuro.value = nuevoModo
                                lifecycleScope.launch {
                                }
                            },
                            volver = { pantallaActual.value = "inicio" }
                        )
                        "formulario" -> PantallaFormulario(
                            guardarYVolver = { nombre, pokemonFav ->
                                lifecycleScope.launch {
                                    registroDao.insertar(Registro(nombre = nombre, pokemonFav = pokemonFav))
                                }
                                pantallaActual.value = "inicio"
                            },
                            volver = { pantallaActual.value = "inicio" }
                        )
                    }
                }
            }
        }
    }
}