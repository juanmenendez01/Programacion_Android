package com.sena.activity_1.View.Transition

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.navigation.NavController

@Composable
fun Pagina1(navController: NavController){

    val configuration = LocalConfiguration.current
    //var texto by remember { mutableStateOf("") }  este mantiene algo en el componente
    var data by rememberSaveable { mutableStateOf("") } // este mantiene algo a nivel aplicacion

    when(configuration.orientation){
        Configuration.ORIENTATION_LANDSCAPE -> {
            LazyColumn {
                item {
                    Column (modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        Alignment.CenterHorizontally
                    ) {

                        Text(text = "Hola perra")

                        TextField(
                            value = data,
                            onValueChange = {data = it},
                            label = {Text(text = "Nombre")}

                        )

                        Button(
                            onClick = {
                                navController.navigate("pagina2/$data")
                            }
                        ) {
                            Text(text = "Ir a la vista 2")
                        }
                    }
                }
            }
        }
        Configuration.ORIENTATION_PORTRAIT -> {

            Column (modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                Alignment.CenterHorizontally
            ) {

                Text(text = "Hola perra")

                TextField(
                    value = data,
                    onValueChange = {data = it},
                    label = {Text(text = "Nombre")}

                )

                Button(
                    onClick = {
                        navController.navigate("pagina2/$data")
                    }
                ) {
                    Text(text = "Ir a la vista 2")
                }
            }
        }
    }



}