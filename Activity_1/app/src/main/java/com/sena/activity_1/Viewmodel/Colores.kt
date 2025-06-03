package com.sena.activity_1.Viewmodel

import android.R
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Colores: ViewModel(){

    var count by mutableStateOf(0)
    var nombre by mutableStateOf("")
    var contrasena by mutableStateOf("")
    var contrasena2 by mutableStateOf("")
    var confirmarContraseña by mutableStateOf(false)
    var correo by mutableStateOf("")
    var telefono by mutableStateOf("")
    var soloDigitos by mutableStateOf("")
    var valnombre by mutableStateOf(false)
    var valtel by mutableStateOf(false)
    var length by mutableStateOf(false)
    var valemail by mutableStateOf(false)
    var dark by mutableStateOf(false)
    val colorScheme = if (dark) darkColorScheme() else lightColorScheme()
    var actividades by mutableStateOf(listOf("Actividad 1", "Actividad 2", "Actividad 3", "Actividad 4"))
    val actividad = mutableStateListOf(false, false, false, false)
    var campoTexto by mutableStateOf("")
    var valcampoTexto by mutableStateOf(false)
    var cargando by mutableStateOf(false)
    var completo by mutableStateOf(false)

    fun simular() {
        viewModelScope.launch {
            cargando = true
            completo = false

            delay(2000)

            cargando = false
            completo = true
        }
    }
    fun reiniciar() {
        cargando = false
        completo = false
    }
}
