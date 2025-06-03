package com.sena.activity_1.View.Activity3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Colores

@Composable
fun Validacion(Colores : Colores = viewModel())
{
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center

    )
    {
        Column() {

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
                label = { Text(text = "Ingesa un correo") }
            )

            Button(
                enabled = Colores.length && Colores.valemail,
                onClick = {

                }
            )
            {
                Text(text = "Guardar")
            }

            if (Colores.length == false && Colores.valemail == false)
            {
                Text(text = "Ingrese un correo y contraseña", color = Color.Red)
            }else if (Colores.length == false){
                Text(text = "Ingrese una contraseña valida", color = Color.Red)
            } else if (Colores.valemail == false){
                Text(text = "Correo invalido", color = Color.Red)
            }

        }
    }
}