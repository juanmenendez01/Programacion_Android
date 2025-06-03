package com.sena.activity_1.View.Transition

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sena.activity_1.Viewmodel.Botones


@Composable
fun Formulario(Botones: Botones = viewModel()){

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Column (){
            OutlinedTextField(
                value = Botones.nombre,
                onValueChange = {Botones.nombre = it},
                label = { Text(text = "Nombre") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text),
                singleLine = true,
            )
            OutlinedTextField(
                value = Botones.edad,
                onValueChange = {Botones.edad = it},
                label = { Text(text = "Edad") },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number),
                singleLine = true
            )
            OutlinedTextField(
                value = Botones.contrsena,
                onValueChange = {Botones.contrsena = it},
                label = { Text(text = "Password") },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation()


            )

            Text(text = "Altura: ${Botones.altura.toString()}")
            Slider(
                value = Botones.altura.toFloat(),
                onValueChange = { Botones.altura = it.toInt()},
                valueRange = 0f .. 100f,
                steps = 200,
                modifier = Modifier.fillMaxWidth(0.9f)

            )
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Checkbox(
                    checked = Botones.terminos,
                    onCheckedChange = {Botones.terminos = it}
                )
                Text(text = "Terminos y condiciones")
            }

            repeat(Botones.generos.size)
            {
                Row (
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    RadioButton(selected = Botones.genero == Botones.generos[it],
                        onClick = {Botones.genero = Botones.generos[it]})
                    Text(Botones.generos[it])
                }
            }

            Button(
                enabled = Botones.terminos && Botones.genero.isNotEmpty(),
                onClick = {
                    Botones.Guardar()
                }
            ) {
                Text(text = "Guardar")
            }
        }
    }
}