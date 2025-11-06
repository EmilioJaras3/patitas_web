package com.example.examen.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaPrincipal(
    irATema: () -> Unit,
    irAFormulario: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Mi App",
            style = MaterialTheme.typography.headlineLarge
        )
        
        Spacer(modifier = Modifier.height(32.dp))
        
        Button(onClick = irATema) {
            Text("Cambiar Tema")
        }
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(onClick = irAFormulario) {
            Text("Ir al Formulario")
        }
    }
}