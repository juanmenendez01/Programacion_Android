package com.sena.activity_1.View.Transition

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.LineHeightStyle

@Composable
fun TemaDinamico()
{
    var isDark by rememberSaveable { mutableStateOf(false) }
    val colorScheme = if (isDark) darkColorScheme() else lightColorScheme()
    MaterialTheme(
        colorScheme = colorScheme
    )
    {
        Column(
            modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            Alignment.CenterHorizontally
        )
        {
            Text(text = "Hola mundoooooooooo", color = Color.LightGray)
            Button(
                onClick = {isDark = !isDark}
            )
            {
                Text(text = "Cambiar color")
            }

        }

    }
}