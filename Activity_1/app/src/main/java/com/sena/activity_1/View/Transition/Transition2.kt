package com.sena.activity_1.View.Transition

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun Pagina2(navController: NavController, nombre : String?){

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        Alignment.CenterHorizontally
        )
    {
        Text(text = "Hola perra $nombre")

        Button(
            onClick = {
                navController.navigate("pagina1")
            }
        ) {
            Text(text = "Ir a la vista 1")
        }
    }

}


