package com.sena.project_1.View.ActivityOne

import android.inputmethodservice.Keyboard
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.project_1.R

@Composable
fun Estudiante(){

    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
        ) {
        Row()
        {
            Text(text = "bibi",
                fontSize = 60.sp,
                fontWeight = FontWeight.Bold,
            )

        }
        Row()
        {
            Image(painter = painterResource(id = R.drawable.estudiante), contentDescription = "Imagen1")

        }

            Fila_("Para estudiantes que quieren convertirse en asistentes de vuelos")


            Fila("Comunicate para convertirte en asistente de vuelo y cumplir y¿tu sueño con nosotros, encuentra informacion que te ayudara")
    }
}

@Composable
fun Fila(texto: String){
    Text(texto, modifier = Modifier.fillMaxWidth(0.8f).padding(start = 10.dp, end = 10.dp), textAlign = TextAlign.Center, )
}
@Composable
fun Fila_(texto: String){
    Text(texto, modifier = Modifier.fillMaxWidth(0.8f), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold)
}