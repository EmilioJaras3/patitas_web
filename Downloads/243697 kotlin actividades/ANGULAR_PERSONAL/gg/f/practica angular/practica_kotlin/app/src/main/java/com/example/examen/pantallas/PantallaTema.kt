package com.example.examen.pantallas

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PantallaTema(
    modoOscuro: Boolean,
    cambiarTema: (Boolean) -> Unit,
    volver: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("CAMBIAR MODO DEL TEMA" +
                "")
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Switch(
            checked = modoOscuro,
            onCheckedChange = cambiarTema
        )
        
        Text(if (modoOscuro) "Modo Oscuro" else "Modo Claro")
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(onClick = volver) {
            Text("Volver")
        }
    }
}