package com.sena.activity_1.View.Activity3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Colores
import java.nio.file.WatchEvent

@Composable
fun campoDeTexto(Colores: Colores = viewModel()){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        OutlinedTextField(
            value = Colores.campoTexto,
            onValueChange = {
                Colores.campoTexto = it
            },
            maxLines = 10,
            label = { Text(text = "Ingesa un texto") }
        )
        Text(
            text = "${Colores.campoTexto.length}/100",
            color = if (Colores.campoTexto.length >= 100) Color.Red else Color.Gray,
        )
    }
}
