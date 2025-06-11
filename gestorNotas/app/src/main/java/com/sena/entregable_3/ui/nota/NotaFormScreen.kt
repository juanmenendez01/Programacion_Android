package com.sena.entregable_3.ui.nota

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.room.util.TableInfo
import com.sena.entregable_3.viewmodel.ClienteViewModel
import com.sena.entregable_3.viewmodel.NotaViewModel

@Composable
fun formNotas(
    navController: NavController,
    notaViewModel: NotaViewModel = viewModel(),
    clienteViewModel: ClienteViewModel = viewModel(),
    notaId: Int
) {
    val clientes by clienteViewModel.allCliente.collectAsState()
    var selectedClienteNombre by remember { mutableStateOf("") }
    var selectedClienteId by remember { mutableStateOf<Int?>(null) }
    var expanded by remember { mutableStateOf(false) }
    var contenido by rememberSaveable { mutableStateOf("") }

    if (notaId > 0) {
        // Formulario Actulizacion
        LaunchedEffect(notaId) {
            notaViewModel.notaById(notaId)
        }
        val nota = notaViewModel.nota.value
        if (nota != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "Actualizar notas",
                    modifier = Modifier.padding(vertical = 30.dp),
                    fontSize = 30.sp
                )
                val nombreCliente = clientes.find { it.id == nota.idCliente }?.nombre ?: "Desconocido"
                // Menu para seleccionar cliente
                Box {
                    Column {
                        Text(text = "Cliente anterior: $nombreCliente")
                        OutlinedTextField(
                            value = selectedClienteNombre,
                            onValueChange = {},
                            readOnly = true,
                            label = { Text("Selecciona un cliente") },
                            trailingIcon = {
                                IconButton(onClick = { expanded = true }) {
                                    Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                                }
                            }
                        )
                        DropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            clientes.forEach { cliente ->
                                DropdownMenuItem(
                                    text = { Text(cliente.nombre) },
                                    onClick = {
                                        selectedClienteNombre = cliente.nombre
                                        selectedClienteId = cliente.id
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                OutlinedTextField(
                    label = { Text("Contenido") },
                    placeholder = { Text(text = nota.contenido) },
                    value = contenido,
                    onValueChange = { contenido = it }
                )

                Spacer(modifier = Modifier.height(20.dp))

                Button(
                    onClick = {
                        if (selectedClienteId != null && contenido.isNotBlank()) {
                            notaViewModel.updateNota(notaId, contenido, selectedClienteId!!)
                            navController.popBackStack()
                        }
                    }
                ) {
                    Text("Actualizar")
                }
            }
        } else {
            Text(text = "cargando datos...")
        }
    } else {
        // Formulario Inserción
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "Registro de notas",
                modifier = Modifier.padding(vertical = 30.dp),
                fontSize = 30.sp
            )

            // Menu para seleccionar cliente
            Box {
                OutlinedTextField(
                    value = selectedClienteNombre,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Selecciona un cliente") },
                    trailingIcon = {
                        IconButton(onClick = { expanded = true }) {
                            Icon(Icons.Default.ArrowDropDown, contentDescription = null)
                        }
                    }
                )
                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    clientes.forEach { cliente ->
                        DropdownMenuItem(
                            text = { Text(cliente.nombre) },
                            onClick = {
                                selectedClienteNombre = cliente.nombre
                                selectedClienteId = cliente.id
                                expanded = false
                            }
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                label = { Text("Contenido") },
                value = contenido,
                onValueChange = { contenido = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    if (selectedClienteId != null && contenido.isNotBlank()) {
                        notaViewModel.addNota(selectedClienteId!!, contenido)
                        navController.popBackStack()
                    }
                }
            ) {
                Text("Guardar")
            }
        }
    }
}
