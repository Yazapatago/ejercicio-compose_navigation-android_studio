package com.sena.first_project.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AcercaDeScreen(
    onVolver: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Acerca de",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = "App de ejemplo de navegación con Jetpack Compose.")
        Text(text = "Tiene 5 vistas: Inicio, Estudiantes, Detalle del estudiante, Cursos y Acerca de.")
        Text(text = "Versión 1.0")

        Button(onClick = onVolver, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Volver")
        }
    }
}
