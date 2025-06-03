package com.sena.activity_1.view.ActivityOne

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sena.activity_1.R

@Composable
fun SecondPage() {

    val config2 = LocalConfiguration.current

    when(config2.orientation){
        Configuration.ORIENTATION_PORTRAIT ->
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {


                Image(modifier = Modifier.width(300.dp).height(300.dp),
                    painter = painterResource(id = R.drawable.chef),
                    contentDescription = "Description")

                Text(
                    text = "For cabin crew who want to train students",
                    textAlign = TextAlign.Center,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 60.dp)
                )

                Text(text = "Share your knowledge with,\n" +
                        "students, recruit students and" +
                        " earn money on it",

                    fontSize = 16.sp,
                    color = Color.Gray,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(horizontal = 55.dp)
                )

            }
        Configuration.ORIENTATION_LANDSCAPE ->
            LazyColumn {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceEvenly
                    ) {


                        Image(modifier = Modifier.width(300.dp).height(300.dp),
                            painter = painterResource(id = R.drawable.chef),
                            contentDescription = "Description")

                        Text(
                            text = "For cabin crew who want to train students",
                            textAlign = TextAlign.Center,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 60.dp)
                        )

                        Text(text = "Share your knowledge with,\n" +
                                "students, recruit students and" +
                                " earn money on it",

                            fontSize = 16.sp,
                            color = Color.Gray,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.padding(start = 40.dp, bottom = 100.dp, end = 40.dp)
                        )

                    }
                }
            }
    }

}