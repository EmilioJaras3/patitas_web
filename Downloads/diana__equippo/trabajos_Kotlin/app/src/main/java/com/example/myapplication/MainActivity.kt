package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
// Borramos los imports de "Greeting" y "Preview"
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.myapplication.ui.theme.MyApplicationTheme // Tu tema de colores

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // "enableEdgeToEdge()" lo puedes dejar o quitar, no afecta la app

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // ¡Aquí llamamos a nuestro "GPS" y él se encarga de todo!
                    AppNavigation()
                }
            }
        }
    }
}

// BORRAMOS LAS FUNCIONES @Composable Greeting y @Preview GreetingPreview
// Ya no las necesitamos.