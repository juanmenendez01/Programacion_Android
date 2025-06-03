package com.sena.activity_1


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sena.activity_1.View.Activity3.estadoCarga
import com.sena.activity_1.ui.theme.Activity_1Theme
import com.sena.activity_1.view.ActivityOne.FirstPage
import com.sena.activity_1.view.ActivityOne.SecondPage
import com.sena.activity_1.view.ActivityOne.ThirdPage


class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Activity_1Theme {
                Scaffold {
                    estadoCarga()
                    //validarTiempoReal()
                    //campoDeTexto()
                    //Actividades()
                    //Registro()
                    //Fortaleza()
                    //cambiarColor()
                    //Telefono()
                    //Validacion()
                    //ColorNumero()
                    //TemaDinamico()
                    //Formulario()
                    //AppAnimation()
                    //AppNavigator()
                    //HorizontalPages()
                    //MyNavigation()
                }
            }
        }
    }
}

@Composable
fun HorizontalPages(navController: NavController) {
    val pageCount = 3
    val pageState = rememberPagerState(pageCount = { pageCount })

    Box(modifier = Modifier.fillMaxSize()) {
        HorizontalPager(
            state = pageState,
            modifier = Modifier.fillMaxSize()
        ) { page ->
            when (page) {
                0 -> FirstPage()
                1 -> SecondPage()
                2 -> ThirdPage(navController)
                else -> Text(text = "No se encontró")
            }
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(3) { index ->
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .padding(horizontal = 4.dp)
                        .
                        clip(CircleShape)
                        .background(
                            if (pageState.currentPage == index) Color.Red
                            else Color.LightGray
                        )
                )
            }
        }
    }
}


@Composable
fun PrimeraVentanaEjemplo(){
    Box(
        modifier = Modifier.fillMaxSize().background(color = Color(0XFF00d7f9))
    ){
        Text(text = "Hola, desde ventana 1", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun SegundaVentanaEjemplo(){
    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.Green)
    ){
        Text(text = "Hola, desde ventana 2", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun TerceraVentanaEjemplo(){
    Box(
        modifier = Modifier.fillMaxSize().background(color = Color.Red)
    ){
        Text(text = "Hola, desde ventana 3", modifier = Modifier.align(Alignment.Center))
    }
}
