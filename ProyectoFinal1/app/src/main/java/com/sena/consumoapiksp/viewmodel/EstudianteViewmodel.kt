package com.sena.consumoapiksp.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sena.consumoapiksp.model.EstudianteConNota
import com.sena.consumoapiksp.model.toRemoto
import com.sena.consumoapiksp.remote.Estudiante
import com.sena.consumoapiksp.repository.EstudianteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EstudianteViewmodel @Inject constructor(
    private val repository: EstudianteRepository
): ViewModel() {

    private val _estudiantes = MutableStateFlow<List<EstudianteConNota>>(emptyList())
    val estudiantes: StateFlow<List<EstudianteConNota>> = _estudiantes


    private val _loading = MutableStateFlow(false)
    val loading: StateFlow<Boolean> = _loading

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    var estudianteSeleccionado = mutableStateOf<EstudianteConNota?>(null)
        private set

    fun seleccionarEstudiante(est: EstudianteConNota) {
        estudianteSeleccionado.value = est
    }

    fun fetchEstudiantes(){
        viewModelScope.launch {
            _loading.value = true
            _error.value = null
            try {
                val listaLocal = repository.getAllEstudiantesLocal()
                Log.d("EstudianteViewmodel", "Lista local estudiantes: $listaLocal")
                _estudiantes.value = listaLocal
            } catch (e: Exception){
                _error.value = "Error al cargar estudiante ${e.localizedMessage}"
                Log.e("EstudianteViewmodel", "Error fetchEstudiantes", e)
            } finally {
                _loading.value = false
            }
        }
    }

    fun addEstudiante(id: Int, nombre: String, programa: String, nota: Float){
        viewModelScope.launch {
            try {
                val newEstudiante = Estudiante(
                    IdEstudiante = id,
                    NombreEstudiante = nombre,
                    ProgramaEstudiante = programa,
                    NotaEstudiante = nota
                )
                Log.d("API_DEBUG", "Estudiante enviado: $newEstudiante")
                repository.createEstudiantes(newEstudiante)
                Log.d("API_DEBUG", "Guardado exitoso")
                fetchEstudiantes()
            } catch (e: Exception){
                Log.e("API_ERROR", "Error al guardar: ${e.message}", e)
            }
        }
    }

    fun deleteEstudiante(id: Int){
        viewModelScope.launch {
            try {
                repository.deleteEstudiantes(id)
                fetchEstudiantes()
            } catch (e: Exception){
                _error.value = "Error al eliminar estudiante: ${e.localizedMessage}"
            }
        }
    }

    fun updateEstudiante(id: Int, estudiante: Estudiante){
        viewModelScope.launch {
            try {
                repository.updateEstudiantes(id, estudiante)
                fetchEstudiantes()
            } catch (e: Exception){
                _error.value = "Error al actualizar estudiante: ${e.localizedMessage}"
            }
        }
    }

    private fun startPolling(){
        viewModelScope.launch {
            while (true){
                fetchEstudiantes()
                delay(5000L)
            }
        }
    }
}
