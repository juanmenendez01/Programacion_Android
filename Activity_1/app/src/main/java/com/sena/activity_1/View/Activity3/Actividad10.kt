package com.sena.activity_1.View.Activity3

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Colores
import kotlinx.coroutines.delay

@Composable
fun estadoCarga(Colores: Colores = viewModel()) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (Colores.cargando) {
            CircularProgressIndicator()
            Text("Cargando...", modifier = Modifier.padding(top = 8.dp))
        } else {
            Button(
                onClick = {
                    if (!Colores.completo) {
                        Colores.simular()
                    } else {
                        Colores.reiniciar()
                    }
                }
            ) {
                Text(
                    when {
                        Colores.cargando -> "Cargando..."
                        else -> "Iniciar acción"
                    }
                )
            }
        }
    }
}