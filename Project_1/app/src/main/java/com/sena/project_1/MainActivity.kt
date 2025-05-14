package com.example.project_1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sena.project_1.R
import com.sena.project_1.View.ActivityOne.Cabin
import com.sena.project_1.View.ActivityOne.Cel
import com.sena.project_1.View.ActivityOne.Estudiante
import com.sena.project_1.View.Scrol
import com.sena.project_1.ui.theme.Project_1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project_1Theme {
                Scrol()
            }
        }
    }
}

@SuppressLint("MutableCollectionMutableState")
@Composable
fun texto(text: String){

    var input by remember { mutableStateOf("") }


    Column(modifier = Modifier.fillMaxSize().padding(54.dp)) {

        Box(){
            TextField(
                value = input,
                onValueChange = {input = it},
                label = {
                    Text(text = "Escibre algo") // placehodler
                },
                placeholder = {
                    Text(text = "AAAAAAAA")
                }
            )
        }


        Box(modifier = Modifier.fillMaxHeight(0.5f)
            .fillMaxWidth()
            .background(Color.Blue)
        ){
            Text(
                text = "HOLA MUNDO",
                modifier = Modifier.fillMaxSize(),
                textAlign = TextAlign.Center,
                color = Color.Red,
                fontWeight = FontWeight.Bold
            )

            Text(text = input, color = Color.White)

            Button(
                onClick = {
                    input = "ok"
                }

            ) {
                Text(text = "Enviar")
            }
        }

        Box(modifier = Modifier.fillMaxHeight(1f)) {
            Image(modifier = Modifier.fillMaxSize(), painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Description")
        }

    }
}

@Composable
fun mostrarImagen(){

    Box(modifier = Modifier.fillMaxHeight(1f)) {
        Image(modifier = Modifier.fillMaxSize(),
            painter = painterResource(id = R.drawable.img1),
            contentDescription = "Description")
    }
}

@Composable
fun Base(){
//        Column(modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally) {
//
//            Fila(0.5f)
//
//            Row {Texto("TEXTO EN MEDIO", modifier = Modifier.fillMaxWidth())}
//
//            Fila(fraction = 1f)
//        }

    texto("")
}

@Composable
fun Texto(text: String, modifier: Modifier = Modifier) {
    Text(
        text = text,
        modifier = modifier,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Fila(fraction: Float, modifier: Modifier = Modifier){
    Row(modifier = Modifier.fillMaxWidth().fillMaxHeight(fraction),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Texto("MI texto 3", modifier = Modifier.fillMaxWidth(0.5f))
        Texto("MI texto 4", modifier = Modifier.fillMaxWidth(1f)) // Ocupa el resto disponible
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview() {
    Project_1Theme {
        Cel()
        //Cabin()
        //Estudiante()

    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Project_1Theme {
//        Greeting("Android")
//    }
//}
