package com.sena.entregable_3.ui.cliente

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sena.entregable_3.viewmodel.ClienteViewModel

@Composable
fun formCliente(navController: NavController, viewModel: ClienteViewModel, id: Int) {
    var nombre by rememberSaveable { mutableStateOf("") }
    var correo by rememberSaveable { mutableStateOf("") }
    if (id > 0) {
        // Es un efecto secundario controlado por Compose, que se ejecuta una sola vez (o cuando cambia su clave: idCliente en este caso).
        LaunchedEffect(id) {
            // Cuando se cargue la pantalla o se abra, llama al viewmodel para que cargue el cliente desde la db
            viewModel.clienteById(id)
        }
        // Con esto accedemos al valor guardado en el viewmodel
        val cliente = viewModel.cliente.value
        if (cliente != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // Form Actualización
                Text(
                    text = "Actulizacion de clientes",
                    modifier = Modifier.padding(vertical = 30.dp),
                    fontSize = 25.sp
                )
                Text(
                    text = "Id Cliente: ${id}",
                    modifier = Modifier.padding(vertical = 20.dp),
                    fontSize = 18.sp
                )
                OutlinedTextField(
                    label = { Text(text = "Actualizar nombre") },
                    placeholder = { Text(text = cliente.nombre) },
                    value = nombre,
                    onValueChange = { nombre = it }
                )
                OutlinedTextField(
                    label = { Text(text = "Actualizar correo") },
                    placeholder = { Text(text = cliente.correo) },
                    value = correo,
                    onValueChange = { correo = it }
                )
                Button(
                    onClick = {
                        viewModel.updateCliente(id, nombre, correo)
                        nombre = ""
                        correo = ""
                        navController.popBackStack()
                    },
                    modifier = Modifier.padding(top = 24.dp)
                ) {
                    Text(text = "Actualizar")
                }

            }
        } else {
            Text(text = "Cargando datos")
        }
    } else {
        // Form Inserción
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Registro de clientes",
                modifier = Modifier.padding(vertical = 30.dp),
                fontSize = 30.sp
            )

            OutlinedTextField(
                label = { Text(text = "Nombre del cliente") },
                value = nombre,
                onValueChange = { nombre = it }
            )

            OutlinedTextField(
                label = { Text(text = "Correo del cliente") },
                value = correo,
                onValueChange = { correo = it }
            )

            Button(
                onClick = {
                    viewModel.addCliente(nombre, correo)
                    nombre = ""
                    correo = ""
                    navController.popBackStack()
                },
                modifier = Modifier.padding(top = 24.dp)
            ) {
                Text(text = "Guardar")
            }
        }
    }
}
