package com.sena.consumoapiksp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sena.consumoapiksp.remote.Estudiante
import com.sena.consumoapiksp.viewmodel.EstudianteViewmodel

@Composable
fun Actualizar(navController: NavController, estudianteId: Int) {
    val viewModel: EstudianteViewmodel = hiltViewModel()
    val estudiantes by viewModel.estudiantes.collectAsState()

    var id by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var programa by remember { mutableStateOf("") }
    var nota by remember { mutableStateOf("") }
    var yaAsignado by remember { mutableStateOf(false) }

    // Asegura que los datos se carguen antes de buscar el estudiante
    LaunchedEffect(Unit) {
        if (estudiantes.isEmpty()) {
            viewModel.fetchEstudiantes()
        }
    }

    // Autocompleta cuando los datos estén disponibles
    LaunchedEffect(estudiantes) {
        if (!yaAsignado) {
            val seleccionado = estudiantes.find { it.estudiante.idEstudiante == estudianteId }
            seleccionado?.let {
                id = it.estudiante.idEstudiante.toString()
                nombre = it.estudiante.nombreEstudiante
                programa = it.estudiante.programaEstudiante
                nota = it.nota?.notaFinal?.toString() ?: "0.0"
                yaAsignado = true
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Actualizar estudiante", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text("ID del estudiante") },
            enabled = false
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre del estudiante") }
        )

        OutlinedTextField(
            value = programa,
            onValueChange = { programa = it },
            label = { Text("Programa académico") }
        )

        OutlinedTextField(
            value = nota,
            onValueChange = { nota = it },
            label = { Text("Nota final") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {
                val estudiante = Estudiante(
                    id.toInt(),
                    nombre,
                    programa,
                    nota.toFloatOrNull() ?: 0f
                )
                viewModel.updateEstudiante(id.toInt(), estudiante)
                navController.navigate("lista")
            }) {
                Text("Actualizar")
            }
        }
    }
}
