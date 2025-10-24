// También está en el paquete ".screens"
package com.example.myapplication.screens

// Todos los imports necesarios para esta pantalla
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

// La "receta" de la UI para las Corutinas
@Composable
fun CoroutinesScreen() {
    // Variables de estado
    var isLoading by remember { mutableStateOf(false) }
    var resultText by remember { mutableStateOf("Presiona un botón para iniciar una tarea") }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Button(onClick = {
            coroutineScope.launch {
                isLoading = true
                resultText = "Ejecutando Tarea 1..."
                delay(2000)
                resultText = "✅ Tarea 1 completada"
                isLoading = false
            }
        }) {
            Text("Iniciar Tarea Larga (2s)")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            coroutineScope.launch {
                isLoading = true
                resultText = "Ejecutando Tarea 2..."
                delay(4000)
                resultText = "✅ Tarea 2 completada"
                isLoading = false
            }
        }) {
            Text("Iniciar Tarea Muy Larga (4s)")
        }

        Spacer(modifier = Modifier.height(8.dp))

        Button(onClick = {
            coroutineScope.launch {
                isLoading = true
                resultText = "Ejecutando Tarea 3..."
                delay(1000)
                resultText = "✅ Tarea 3 completada"
                isLoading = false
            }
        }) {
            Text("Iniciar Tarea Rápida (1s)")
        }

        Spacer(modifier = Modifier.height(32.dp))

        // UI Condicional
        if (isLoading) {
            CircularProgressIndicator()
        } else {
            Text(text = resultText)
        }
    }
}