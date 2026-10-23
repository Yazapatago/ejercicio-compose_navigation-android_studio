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
fun HomeScreen(
    onirEstudiantes: () -> Unit,
    onirCursos: () -> Unit,
    onirAcercaDe: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Escuela",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(text = "Bienvenido. Elige una opción del menú:")

        Button(onClick = onirEstudiantes, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Estudiantes")
        }
        Button(onClick = onirCursos, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Cursos")
        }
        Button(onClick = onirAcercaDe, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Acerca de")
        }
    }
}
