package com.sena.project_1.View.ActivityOne

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.project_1.R

@Composable
fun Cel(){

    Column(modifier = Modifier.fillMaxHeight().fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Row()
        {
            Text(text = "bibi",
                fontSize = 60.sp,
                fontWeight = FontWeight.ExtraBold
            )

        }
        Row()
        {
            Image(painter = painterResource(id = R.drawable.cel), contentDescription = "Imagen2", modifier = Modifier.fillMaxWidth(0.5f))

        }

        Fila4("Get Statrted")


        Fila6("Already have an account?")
    }
}

@Composable

fun Fila6(texto: String,){

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Button(
            onClick = {

            },
            modifier = Modifier.fillMaxWidth(0.8f).fillMaxHeight(0.1f),
            colors = ButtonColors(
                contentColor = Color.Black,
                containerColor = Color.White,
                disabledContentColor = Color.White,
                disabledContainerColor = Color.White
            ),
            border = BorderStroke(width = 1.dp, color = Color.Red)


        ){
            Text(text = "REGISTRATION", color = Color.Black)
        }

        Row(modifier = Modifier.padding(top = 20.dp)) {
            Text(texto)
            Text(text = "Login", color = Color.Red, modifier = Modifier.padding(start = 2.dp))
        }
    }
}
@Composable
fun Fila4(texto: String){
    Text(texto, modifier = Modifier.fillMaxWidth(0.8f), textAlign = TextAlign.Center, fontWeight = FontWeight.Bold, fontSize = 30.sp)
}