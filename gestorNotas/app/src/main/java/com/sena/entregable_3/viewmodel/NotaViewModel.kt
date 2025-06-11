package com.sena.entregable_3.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sena.entregable_3.data.local.Notas
import com.sena.entregable_3.data.repository.NotaRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class NotaViewModel(private val notaRepository: NotaRepository) : ViewModel() {

    val allNotas = notaRepository.getNotas.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    private val _nota = mutableStateOf<Notas?>(null)
    val nota: State<Notas?> get() = _nota
    fun notaById(id: Int) {
        viewModelScope.launch {
            _nota.value = notaRepository.notaById(id)
        }
    }

    fun addNota(idCliente: Int, contenido: String) {
        val fechaActual = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val nuevaNota = Notas(contenido = contenido, fecha = fechaActual, idCliente = idCliente)
        viewModelScope.launch {
            notaRepository.insertar(nuevaNota)
        }
    }

    fun updateNota(id: Int, contenido: String, idCliente: Int) {
        val fechaActualizada = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        val notaActualizada = Notas(id = id, contenido = contenido, fecha = fechaActualizada, idCliente = idCliente)
        viewModelScope.launch {
            notaRepository.update(notaActualizada)
        }
    }

    fun deleteNota(nota: Notas) {
        viewModelScope.launch {
            notaRepository.deleteNota(nota)
        }
    }
}

