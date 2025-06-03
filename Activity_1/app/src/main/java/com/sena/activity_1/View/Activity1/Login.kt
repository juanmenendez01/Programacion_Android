package com.sena.activity_1.View.Activity1

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sena.activity_1.R
import com.sena.activity_1.view.ActivityTwo.Inputs

@Composable
fun Login(navController: NavController){

    val config4 = LocalConfiguration.current

    when(config4.orientation){

        Configuration.ORIENTATION_PORTRAIT ->
            Column(modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                ImagenLogin()
                Inputs()
                LoginButton()
                Row(
                    modifier = Modifier.padding(top = 30.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "Si no tienes una cuenta da click en: ")
                    Button(
                        onClick = {
                            navController.navigate("registro")
                        },
                        colors =  ButtonColors(
                            contentColor = Color.White,
                            containerColor = Color.LightGray,
                            disabledContentColor = Color.Gray,
                            disabledContainerColor = Color.Gray
                        )

                    ) {
                        Text(text = "Registrarse", color = Color.Red,
                            textAlign = TextAlign.Center)
                    }
                }


            }

        Configuration.ORIENTATION_LANDSCAPE ->
            LazyColumn {
                item {
                    Column(modifier = Modifier.fillMaxSize().padding(start = 40.dp, bottom = 70.dp, end = 40.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    )
                    {
                        ImagenLogin()
                        Inputs()
                        LoginButton()
                        Row(
                            modifier = Modifier.padding(top = 30.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(text = "Si no tienes una cuenta da click en: ")
                            Button(
                                onClick = {
                                    navController.navigate("registro")
                                },
                                colors =  ButtonColors(
                                    contentColor = Color.White,
                                    containerColor = Color.LightGray,
                                    disabledContentColor = Color.Gray,
                                    disabledContainerColor = Color.Gray
                                )

                            ) {
                                Text(text = "Registrarse", color = Color.Red,
                                    textAlign = TextAlign.Center)
                            }
                        }


                    }
                }
            }
    }


}

@Composable
fun Inputs(){

    var usuario by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }

    TextField(
        value = usuario,
        onValueChange = {usuario = it},
        label = {Text(text = "Usuario")},
        shape = RoundedCornerShape(20.dp),
    )
    TextField(
        value = contraseña,
        onValueChange = {contraseña = it},
        label = {Text(text = "Contraseña")},
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier.padding(top = 30.dp)

    )
}
@Composable
fun ImagenLogin(){

    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = "Fondo",
        modifier = Modifier.width(150.dp). height(150.dp),
        contentScale = ContentScale.Crop

    )
    Text(text = "Inicia sesion", modifier = Modifier.padding(bottom = 50.dp))
}

@Composable
fun LoginButton(){
    Button(
        onClick = {

        },
        modifier = Modifier.fillMaxWidth(0.6f)
    ) {
        Text(text = "Login")
    }


}
