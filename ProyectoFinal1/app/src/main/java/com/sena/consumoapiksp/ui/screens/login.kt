package com.sena.consumoapiksp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.sena.consumoapiksp.viewmodel.AdminViewModel

@Composable
fun Loguin(navController: NavController) {
    val viewmodel: AdminViewModel = hiltViewModel()

    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }

    val loginSuccess by viewmodel.loginSuccess
    val mensaje by viewmodel.loginMessage

    // Inserta admin por defecto al iniciar la pantalla
    LaunchedEffect(Unit) {
        viewmodel.insertarAdminPorDefecto()
    }

    LaunchedEffect(loginSuccess) {
        if (loginSuccess) {
            correo = ""
            contrasena = ""
            navController.navigate("lista") {
                popUpTo("login") { inclusive = true }
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Inicio de sesión", fontSize = 30.sp)

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = contrasena,
            onValueChange = { contrasena = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth(0.8f)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { viewmodel.login(correo, contrasena) }) {
            Text("Iniciar")
        }

        if (!loginSuccess && !mensaje.isNullOrBlank()) {
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = mensaje ?: "", color = Color.Red)
        }
    }
}
