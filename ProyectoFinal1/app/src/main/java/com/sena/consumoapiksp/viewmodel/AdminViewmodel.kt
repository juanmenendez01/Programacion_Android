package com.sena.consumoapiksp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sena.consumoapiksp.model.AdminLocal
import com.sena.consumoapiksp.repository.AdminRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class AdminViewModel @Inject constructor(
    private val repository: AdminRepository
) : ViewModel() {

    var loginSuccess = mutableStateOf(false)
        private set

    var loginMessage = mutableStateOf<String?>(null)
        private set

    fun login(correo: String, contrasena: String) {
        viewModelScope.launch {
            try {
                val (success, message) = repository.login(correo, contrasena)
                loginSuccess.value = success
                loginMessage.value = message
            } catch (e: Exception) {
                loginSuccess.value = false
                loginMessage.value = "Error inesperado: ${e.localizedMessage ?: e.message}"
                Log.e("AdminViewModel", "Error en login", e)
            }
        }
    }

    fun insertarAdminPorDefecto() {
        viewModelScope.launch {
            try {
                repository.insertarAdmin("menendez@gmail.com", "admin123")
            } catch (_: Exception) {}
        }
    }
}


