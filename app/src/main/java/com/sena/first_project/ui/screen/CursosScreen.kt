package com.sena.first_project.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sena.first_project.data.listaCursos
import com.sena.first_project.data.listaEstudiantes

@Composable
fun CursosScreen(
    onirEstudiantes: () -> Unit,
    onVolver: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Cursos",
            style = MaterialTheme.typography.headlineMedium
        )

        // Muestra cada curso con la cantidad de estudiantes inscritos
        listaCursos.forEach { curso ->
            val cantidad = listaEstudiantes.count { it.curso == curso }
            Text(text = "• $curso ($cantidad estudiantes)")
        }

        OutlinedButton(onClick = onirEstudiantes, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Ver estudiantes")
        }
        Button(onClick = onVolver, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Volver")
        }
    }
}
