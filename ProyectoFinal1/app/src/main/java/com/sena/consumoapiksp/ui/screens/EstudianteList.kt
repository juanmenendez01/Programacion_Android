package com.sena.consumoapiksp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sena.consumoapiksp.model.EstudianteConNota
import com.sena.consumoapiksp.viewmodel.EstudianteViewmodel

@Composable
fun ListaEstudiantes(navController: NavController) {
    val viewModel: EstudianteViewmodel = hiltViewModel()
    val estudiantes by viewModel.estudiantes.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.fetchEstudiantes()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Estudiantes Registrados", fontSize = 22.sp)

        Spacer(modifier = Modifier.height(16.dp))

        if (estudiantes.isEmpty()) {
            Text("No hay estudiantes registrados.")
        } else {
            LazyColumn(modifier = Modifier.weight(1f)) {
                items(estudiantes) { estudianteConNota: EstudianteConNota ->
                    val est = estudianteConNota.estudiante
                    val nota = estudianteConNota.nota

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp)) {
                            Text("ID: ${est.idEstudiante}")
                            Text("Nombre: ${est.nombreEstudiante}")
                            Text("Programa: ${est.programaEstudiante}")
                            Text("Nota: ${nota?.notaFinal ?: "Sin nota"}")

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(onClick = {
                                    viewModel.seleccionarEstudiante(estudianteConNota)
                                    navController.navigate("actualizar/${est.idEstudiante}")

                                }) {
                                    Text("Actualizar")
                                }

                                Button(onClick = {
                                    viewModel.deleteEstudiante(est.idEstudiante)
                                }) {
                                    Text("Eliminar")
                                }
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { navController.navigate("registro") },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar nuevo estudiante")
        }
    }
}
