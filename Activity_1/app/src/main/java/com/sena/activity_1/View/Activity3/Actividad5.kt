package com.sena.activity_1.View.Activity3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Colores

@Composable
fun Fortaleza(Colores:  Colores = viewModel()){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        OutlinedTextField(
            value = Colores.contrasena,
            onValueChange = {
                Colores.contrasena = it
            },
            label = {Text(text = "Contraseña")}
        )
        Row (){
            Text(text = "Fortaleza:  ")
            if (Colores.contrasena.length < 6)
            {
                Text(text = "Debil", color = Color.Red)
            }else if (Colores.contrasena.length > 6 && Colores.contrasena.length <10){
                Text(text = "Media", color = Color.Yellow)
            } else if(Colores.contrasena.length > 10){
                Text(text = "Media", color = Color.Green)
            }
        }

    }
}