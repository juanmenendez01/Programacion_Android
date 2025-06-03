package com.sena.activity_1.Viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class Botones: ViewModel(){
    var nombre by mutableStateOf("")
    var edad by mutableStateOf("")
    var contrsena by mutableStateOf("")
    var generos by mutableStateOf(listOf("femenino", "masculino"))
    var genero by mutableStateOf("")
    var terminos by mutableStateOf(false)
    var altura by mutableStateOf(0)

    fun Guardar(){
        print("Nombre: $nombre")
        print("Edad: $edad")
        print("contraseña: $contrsena")
    }
}