package com.sena.activity_1.View.Activity3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Botones
import com.sena.activity_1.Viewmodel.Colores

@Composable
fun Actividades(Colores: Colores = viewModel()){

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ) {

        for (i in Colores.actividades.indices) {
            Column {
                Row (modifier = Modifier.fillMaxWidth().background(color = if (Colores.actividad[i] == true) Color.Green else Color.White),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    ){
                    Text(text = Colores.actividades[i])
                    Checkbox(
                        checked = Colores.actividad[i],
                        onCheckedChange = {
                            Colores.actividad[i] = it}
                    )
                }
            }
        }

    }
}