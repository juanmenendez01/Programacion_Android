package com.sena.activity_1.view.ActivityTwo

import com.sena.activity_1.R
import android.annotation.SuppressLint
import android.graphics.Paint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.ModifierLocalReadScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@SuppressLint("MutableCollectionMutableState")  /*explicacion mañana */

@Composable
fun RegisterScreen(navController: NavController) {

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        )
    {
        Imagen()
        Inputs()
        RegisterButton()
        Row(
            modifier = Modifier.padding(top = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = "Si ya tienes una cuenta da click en: ")
            Button(
                onClick = {
                    navController.navigate("Login")
                },
                colors =  ButtonColors(
                    contentColor = Color.White,
                    containerColor = Color.LightGray,
                    disabledContentColor = Color.Gray,
                    disabledContainerColor = Color.Gray
                )

                ) {
                Text(text = "Login", color = Color.Red,
                    textAlign = TextAlign.Center)
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
fun Imagen(){

    Image(
        painter = painterResource(id = R.drawable.fondo),
        contentDescription = "Fondo",
        modifier = Modifier.width(150.dp). height(150.dp),
        contentScale = ContentScale.Crop

    )
    Text(text = "Registrarse", modifier = Modifier.padding(bottom = 50.dp))
}

@Composable
fun RegisterButton(){
    Button(
        onClick = {

        },
        modifier = Modifier.fillMaxWidth(0.6f)
    ) {
        Text(text = "Registrarse")
    }


}

