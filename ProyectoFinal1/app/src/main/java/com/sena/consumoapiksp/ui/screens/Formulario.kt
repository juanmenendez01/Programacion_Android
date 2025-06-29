package com.sena.consumoapiksp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sena.consumoapiksp.remote.Estudiante
import com.sena.consumoapiksp.viewmodel.EstudianteViewmodel

@Composable
fun Formulario(navController: NavController) {
    val viewModel: EstudianteViewmodel = hiltViewModel()
    val estudiantes by viewModel.estudiantes.collectAsState()

    var id by rememberSaveable { mutableStateOf("") }
    var nombre by rememberSaveable { mutableStateOf("") }
    var programa by rememberSaveable { mutableStateOf("") }
    var nota by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Formulario de registro", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = id,
            onValueChange = { id = it },
            label = { Text(text = "ID del estudiante") }
        )

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text(text = "Nombre del estudiante") }
        )

        OutlinedTextField(
            value = programa,
            onValueChange = { programa = it },
            label = { Text(text = "Programa académico") }
        )

        OutlinedTextField(
            value = nota,
            onValueChange = { nota = it },
            label = { Text(text = "Nota final") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {


                val idInt = id.toIntOrNull()
                val notaFloat = nota.toFloatOrNull()

                if (idInt != null && notaFloat != null && nombre.isNotBlank() && programa.isNotBlank()) {
                    val estudiante = Estudiante(
                        IdEstudiante = idInt,
                        NombreEstudiante = nombre,
                        ProgramaEstudiante = programa,
                        NotaEstudiante = notaFloat
                    )

                    val existe = estudiantes.any { it.estudiante.idEstudiante == idInt }

                    if (existe) {
                        viewModel.updateEstudiante(idInt, estudiante)
                    } else {

                        val notaf = if (nota.toString() == "") 0 else nota.toFloat()
                        viewModel.addEstudiante(id.toInt(), nombre, programa, notaf.toFloat())

                    }

                    // Limpiar campos
                    id = ""
                    nombre = ""
                    programa = ""
                    nota = ""
                }
            }) {
                Text("Guardar")
            }

            Button(onClick = {
                navController.navigate("lista")
            }) {
                Text("Ver lista")
            }
        }
    }
}
