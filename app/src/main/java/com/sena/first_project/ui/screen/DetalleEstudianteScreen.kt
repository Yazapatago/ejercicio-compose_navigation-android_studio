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
import com.sena.first_project.data.listaEstudiantes

@Composable
fun DetalleEstudianteScreen(
    id: Int,
    onVolver: () -> Unit,
    onVolverInicio: () -> Unit,
) {
    // Busca en la lista el estudiante con ese id (null si no existe)
    val estudiante = listaEstudiantes.find { it.id == id }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Detalle del estudiante",
            style = MaterialTheme.typography.headlineMedium
        )

        if (estudiante != null) {
            Text(text = "Id: ${estudiante.id}")
            Text(text = "Nombre: ${estudiante.nombre}")
            Text(text = "Curso: ${estudiante.curso}")
            Text(text = "Edad: ${estudiante.edad} años")
        } else {
            Text(
                text = "No existe un estudiante con el id $id",
                color = MaterialTheme.colorScheme.error
            )
        }

        Button(onClick = onVolver, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Volver")
        }
        OutlinedButton(onClick = onVolverInicio, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Ir al inicio")
        }
    }
}
