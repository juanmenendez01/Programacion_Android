package com.sena.entregable_3.ui.cliente

import android.graphics.Paint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sena.entregable_3.viewmodel.ClienteViewModel
import java.nio.file.WatchEvent

@Composable
fun listarCliente(navController: NavController, viewModel: ClienteViewModel) {
    val listaClientes = viewModel.allCliente.collectAsState().value
    var clienteId by rememberSaveable { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedClienteNombre by rememberSaveable { mutableStateOf("") }
    var clientesFiltrados = listaClientes.find { it.id.toString() == clienteId }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            Text(text = "Listado de Clientes",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center)
            Row {
                OutlinedTextField(
                    value = clienteId,
                    onValueChange = {
                        clienteId = it
                    },
                    label = {Text(text = "id cliente")}
                )

            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            )
            {
                if (listaClientes.isEmpty()) {
                    Text("No hay clientes registrados.")
                } else {
                    val resultado = if (clienteId.isNotEmpty() && clientesFiltrados != null) {
                        listOf(clientesFiltrados)
                    }else{
                         listaClientes
                        }

                    Column (modifier = Modifier.fillMaxSize(), Arrangement.Center, Alignment.CenterHorizontally) {
                        resultado.forEach { cliente ->
                            Card(
                                modifier = Modifier.fillMaxWidth(0.8f).padding(vertical = 10.dp),


                            ){
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.Absolute.SpaceEvenly,
                                ) {
                                    Text(text = "${cliente.id}")
                                    Text(text = "${viewModel.acortarTexto(cliente.nombre)}")
                                    Text(text = "${viewModel.acortarTexto(cliente.correo)}")
                                }
                                Row {
                                    Button(onClick = {
                                        navController.navigate("clientesForm/${cliente.id}")
                                    }) {
                                        Text("✏️")
                                    }
                                    Button(onClick = {
                                        viewModel.deleteCliente(cliente.id)
                                    }) {
                                        Text("❌")
                                    }
                                }
                            }

                        }
                    }
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(onClick = { navController.navigate("clientesForm") }) {
                    Text("Agregar Cliente")
                }
                Button(onClick = { navController.navigate("notasList") }) {
                    Text("Ver Notas")
                }
            }
        }
    }
}