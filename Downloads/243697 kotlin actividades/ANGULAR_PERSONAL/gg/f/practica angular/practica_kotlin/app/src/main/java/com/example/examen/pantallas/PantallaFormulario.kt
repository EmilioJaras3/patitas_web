package com.example.examen.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaFormulario(
    guardarYVolver: (String, String) -> Unit,
    volver: () -> Unit
) {
    var nombre by remember { mutableStateOf("") }
    var pokemonFav by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Mi Formulario")
        
        Spacer(modifier = Modifier.height(16.dp))
        
        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre") }
        )
        
        Spacer(modifier = Modifier.height(8.dp))
        
        OutlinedTextField(
            value = pokemonFav,
            onValueChange = { pokemonFav = it },
            label = { Text("pokemonFav") }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(onClick = { guardarYVolver(nombre, pokemonFav) }) {
            Text("Guardar")
        }
        
        Spacer(modifier = Modifier.height(8.dp))
        
        Button(onClick = volver) {
            Text("Volver sin guardar")
        }
    }
}