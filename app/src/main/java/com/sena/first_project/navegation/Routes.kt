package com.sena.first_project.navegation

import kotlinx.serialization.Serializable

// Rutas de la aplicación.
// Las rutas que NO reciben datos son data object.
// La ruta que SÍ recibe un dato (el id) es data class.

@Serializable
data object Inicio

@Serializable
data object Estudiantes

// Corrección 1: la ruta termina en "Route" para que no tenga
// el mismo nombre que la pantalla DetalleEstudianteScreen
@Serializable
data class DetalleEstudianteRoute(
    val id: Int,
)

@Serializable
data object Cursos

@Serializable
data object AcercaDe
