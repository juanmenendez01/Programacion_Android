package com.sena.activity_1.View.Activity3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Colores

@Composable
fun Telefono(Colores: Colores = viewModel()){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        OutlinedTextField(
            value = Colores.telefono,
            onValueChange = {
                Colores.telefono = it
                Colores.valtel = it.length == 10
            },
            label = { Text(text = "Ingrese el numero de telefono") },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number),
            singleLine = true,
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = if (Colores.valtel == true) Color.Green else Color.Red,
                unfocusedBorderColor = if (Colores.valtel == true) Color.Green else Color.Red
            )
        )


    }
}