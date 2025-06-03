package com.sena.activity_1.View.Activity3

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Colores

@Composable
fun ColorNumero(Colores: Colores = viewModel()){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {

        Button(
            onClick = { Colores.count ++}
        ) {
            Text(text = "Cambiar color")
        }


        Text(text = Colores.count.toString(), modifier = Modifier.background(if(Colores.count % 2 == 0) Color.Green else Color.Red ))

    }
}