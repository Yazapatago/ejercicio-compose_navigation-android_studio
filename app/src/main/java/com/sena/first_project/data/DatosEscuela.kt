package com.sena.first_project.data

// Datos de ejemplo para la app (no hay base de datos)

data class Estudiante(
    val id: Int,
    val nombre: String,
    val curso: String,
    val edad: Int,
)

val listaEstudiantes = listOf(
    Estudiante(id = 1, nombre = "Ana Gómez", curso = "Programación Kotlin", edad = 18),
    Estudiante(id = 2, nombre = "Carlos Pérez", curso = "Bases de Datos", edad = 20),
    Estudiante(id = 3, nombre = "Laura Martínez", curso = "Diseño Web", edad = 19),
    Estudiante(id = 4, nombre = "Andrés Ríos", curso = "Programación Kotlin", edad = 21),
    Estudiante(id = 5, nombre = "Sofía Herrera", curso = "Redes", edad = 22),
)

val listaCursos = listOf(
    "Programación Kotlin",
    "Bases de Datos",
    "Diseño Web",
    "Redes",
)
