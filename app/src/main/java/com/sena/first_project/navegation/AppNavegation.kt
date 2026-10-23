package com.sena.first_project.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.first_project.ui.screen.AcercaDeScreen
import com.sena.first_project.ui.screen.CursosScreen
import com.sena.first_project.ui.screen.DetalleEstudianteScreen
import com.sena.first_project.ui.screen.EstudiantesScreen
import com.sena.first_project.ui.screen.HomeScreen

// Define la lógica de cómo se van a comunicar las ventanas
@Composable
fun AppNavegation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Inicio
    ) {
        // Vista 1: Inicio (menú principal)
        composable<Inicio> {
            HomeScreen(
                onirEstudiantes = { navController.navigate(Estudiantes) },
                onirCursos = { navController.navigate(Cursos) },
                onirAcercaDe = { navController.navigate(AcercaDe) }
            )
        }

        // Vista 2: Estudiantes (lista + búsqueda por id)
        composable<Estudiantes> {
            EstudiantesScreen(
                onirDetalleEstudiante = { id ->
                    navController.navigate(DetalleEstudianteRoute(id))
                },
                onVolver = { navController.popBackStack() }
            )
        }

        // Vista 3: Detalle del estudiante (recibe el id)
        composable<DetalleEstudianteRoute> { dato ->
            DetalleEstudianteScreen(
                id = dato.arguments?.getInt("id") ?: 0,
                onVolver = { navController.popBackStack() },
                onVolverInicio = {
                    // Quita todas las pantallas hasta dejar Inicio arriba
                    navController.popBackStack(Inicio, inclusive = false)
                }
            )
        }

        // Vista 4: Cursos
        composable<Cursos> {
            CursosScreen(
                onirEstudiantes = { navController.navigate(Estudiantes) },
                onVolver = { navController.popBackStack() }
            )
        }

        // Vista 5: Acerca de
        composable<AcercaDe> {
            AcercaDeScreen(
                onVolver = { navController.popBackStack() }
            )
        }
    }
}
