package com.sena.project_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sena.project_1.ui.theme.Project_1Theme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Project_1Theme {
                Horizontal()
            }
        }
    }
}

@Composable
fun Horizontal(){
    val pagerState = rememberPagerState(pageCount = {3})

    HorizontalPager(state = pagerState)
    {
        page ->
        when(page)
        {
            0 -> PrimerVentana()
            1 -> SegundaVentana()
            2 -> TercerVentana()
            else -> Text(text = "No se encontro la pagina")
        }
    }
    Row(
        modifier = Modifier.fillMaxWidth()
            .padding(25.dp),
            horizontalArrangement = Arrangement.Center
    )
    {
        repeat(3)
        {
                i ->
            Box(
                modifier = Modifier.size(10.dp)
                    .padding(horizontal = 2.dp)
                    .background(if(pagerState.currentPage == i) Color.Black else Color.LightGray.copy(alpha = 3f), shape = CircleShape)
            ){

            }
        }
    }
}
@Composable
fun PrimerVentana(){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xff00d7f9))
    ){
        Text(text = "Holas desde la venta 1", modifier = Modifier.align(Alignment.Center))
    }
}

@Composable
fun SegundaVentana(){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xff00d7f9))
    ){
        Text(text = "Holas desde la venta 2", modifier = Modifier.align(Alignment.Center))
    }

}

@Composable
fun TercerVentana(){
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xff00d7f9))
    ){
        Text(text = "Holas desde la venta 3", modifier = Modifier.align(Alignment.Center))
    }
}

@Preview
@Composable
fun Preview(){
    Horizontal()
}