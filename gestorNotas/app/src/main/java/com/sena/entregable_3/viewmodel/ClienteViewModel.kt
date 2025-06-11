package com.sena.entregable_3.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sena.entregable_3.data.local.Cliente
import com.sena.entregable_3.data.repository.ClienteRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ClienteViewModel(private val ClienteRepository: ClienteRepository) : ViewModel() {

    val allCliente = ClienteRepository.getAll.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = emptyList()
    )

    // Con esto creariamos una variable observable, al nombrarlo con el "_cliente" nos referimos a que es una variable privado, solo se modifica en el mismo Viewmodel
    private val _cliente = mutableStateOf<Cliente?>(null)
    // Esto expone el estado cliente, pero solo como lectura. State<Cliente?> → representa un estado observable e inmutable (solo lectura).
    val cliente: State<Cliente?> get() = _cliente

    fun clienteById(id: Int) {
        viewModelScope.launch {
            _cliente.value = ClienteRepository.clienteById(id)
        }
    }

    fun addCliente(nombre: String, correo: String) {
        val newCliente = Cliente(nombre = nombre, correo = correo)
        viewModelScope.launch {
            ClienteRepository.insert(newCliente)
        }
    }

    fun updateCliente(id: Int, nombre: String, correo: String) {
        val updateCliente = Cliente(id = id, nombre = nombre, correo = correo)
        viewModelScope.launch {
            ClienteRepository.update(updateCliente)
        }
    }

    fun deleteCliente(id: Int) {
        viewModelScope.launch {
            ClienteRepository.delete(id)
        }
    }

    fun acortarTexto(texto: String, maxCaracteres: Int = 13): String {
        return if (texto.length > maxCaracteres) {
            texto.substring(0, maxCaracteres) + "..."
        } else {
            texto
        }
    }


}