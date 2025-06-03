package com.sena.activity_1.View.Activity3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Colores

@Composable
fun Registro(Colores: Colores = viewModel()){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = Colores.nombre,
            onValueChange = {
                Colores.nombre = it
                Colores.valnombre = it.length>0

            },
            label = { Text(text = "Nombre") },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if(Colores.valnombre == false) Color.Red else Color.LightGray,
                unfocusedBorderColor = if (Colores.valtel == true) Color.Green else Color.Red

            )

        )
        OutlinedTextField(
            value = Colores.correo,
            onValueChange = {
                Colores.correo = it
                Colores.valemail = it.contains("@") && it.contains(".com")
            },
            label = { Text(text = "Ingesa un correo") }
        )
        OutlinedTextField(
            value = Colores.contrasena,
            onValueChange = {
                Colores.contrasena = it
                Colores.length = it.length>=6
            },
            label = { Text(text = "Contraseña") }
        )
        OutlinedTextField(
            value = Colores.contrasena2,
            onValueChange = {
                Colores.contrasena2 = it
                Colores.length = it.length>=6
                Colores.confirmarContraseña = (Colores.contrasena == Colores.contrasena2)
            },
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (Colores.confirmarContraseña == true) Color.LightGray else Color.Red,
                unfocusedBorderColor = if (Colores.confirmarContraseña == true) Color.LightGray else Color.Red
            ),
            label = { Text(text = "Confirmar contraseña") }

        )

        if (Colores.length || Colores.valemail || Colores.valnombre || Colores.confirmarContraseña){
            Text(text = "Perfecto!")
        }else{
            Text(text = "Completa los campos", color = Color.Red)
        }
        Button(
            enabled = Colores.confirmarContraseña && Colores.valnombre && Colores.valemail && Colores.length,
            onClick = {

            }
        ) {
            Text(text = "Guardar")
        }


    }
}