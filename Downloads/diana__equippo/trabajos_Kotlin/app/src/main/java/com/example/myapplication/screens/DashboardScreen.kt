// El paquete AHORA es ".screens", indicando que está en esa carpeta
package com.example.myapplication.screens

// Imports necesarios para esta pantalla
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

// La "receta" de la UI para el Dashboard
@Composable
fun DashboardScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Bienvenido al Dashboard")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Acción de navegar a la otra pantalla
            navController.navigate("coroutines_view")
        }) {
            Text("Ir a la Vista de Corutinas")
        }
    }
}