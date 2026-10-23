package com.sena.first_project.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.sena.first_project.data.listaEstudiantes

@Composable
fun EstudiantesScreen(
    onirDetalleEstudiante: (Int) -> Unit,
    onVolver: () -> Unit,
) {
    var id by remember { mutableStateOf("") }
    var error by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // permite desplazar si no cabe en la pantalla
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Estudiantes",
            style = MaterialTheme.typography.headlineMedium
        )

        // Búsqueda por id (como en el ejemplo del profesor)
        OutlinedTextField(
            value = id,
            onValueChange = { nuevoValor ->
                id = nuevoValor
                error = ""
            },
            label = { Text(text = "Buscar estudiante por id") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            isError = error.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )
        if (error.isNotEmpty()) {
            Text(text = error, color = MaterialTheme.colorScheme.error)
        }
        Button(
            onClick = {
                // Corrección 2: toIntOrNull() no cierra la app si el texto no es un número
                val numero = id.toIntOrNull()
                if (numero != null) {
                    onirDetalleEstudiante(numero)
                } else {
                    error = "Escribe un número válido"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Buscar")
        }

        Text(text = "O elige un estudiante de la lista:")

        // Un botón por cada estudiante
        listaEstudiantes.forEach { estudiante ->
            OutlinedButton(
                onClick = { onirDetalleEstudiante(estudiante.id) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "${estudiante.id} - ${estudiante.nombre}")
            }
        }

        Button(onClick = onVolver, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Volver")
        }
    }
}
