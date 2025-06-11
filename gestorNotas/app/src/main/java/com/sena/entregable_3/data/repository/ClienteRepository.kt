package com.sena.entregable_3.data.repository

import com.sena.entregable_3.data.local.Cliente
import com.sena.entregable_3.data.local.ClienteDao
import kotlinx.coroutines.flow.Flow

class ClienteRepository(private val cliente: ClienteDao) {

    val getAll: Flow<List<Cliente>> = cliente.getAll()

    suspend fun clienteById(id: Int): Cliente? {
        return cliente.getClienteById(id)
    }

    suspend fun insert(newClient: Cliente) {
        cliente.insert(newClient)
    }

    suspend fun delete(id: Int) {
        cliente.deleteById(id)
    }

    suspend fun update(updateCliente: Cliente){
        cliente.update(updateCliente)
    }

    /* suspend fun update(updatecliente: Cliente) {
        val clienteById = cliente.getClienteById(updatecliente.id) ?: return
        val clienteActualizado = clienteById.copy(
            nombre = updatecliente.nombre,
            correo = updatecliente.correo
        )
        cliente.update(clienteActualizado)
    } */
}