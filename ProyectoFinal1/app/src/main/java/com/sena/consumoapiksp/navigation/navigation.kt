package com.sena.consumoapiksp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sena.consumoapiksp.ui.screens.Actualizar
import com.sena.consumoapiksp.ui.screens.Formulario
import com.sena.consumoapiksp.ui.screens.ListaEstudiantes
import com.sena.consumoapiksp.ui.screens.Loguin

@Composable

fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login"){
        composable("login"){Loguin(navController)  }
        composable("registro"){Formulario(navController) }
        composable("lista"){ListaEstudiantes(navController)  }
        composable("actualizar/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toIntOrNull() ?: 0
            Actualizar(navController = navController, estudianteId = id)
        }
    }
}