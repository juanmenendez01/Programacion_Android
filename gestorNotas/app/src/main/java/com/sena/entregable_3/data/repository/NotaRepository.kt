package com.sena.entregable_3.data.repository

import com.sena.entregable_3.data.local.Notas
import com.sena.entregable_3.data.local.NotasDao
import kotlinx.coroutines.flow.Flow

class NotaRepository(private val nota: NotasDao) {

    val getNotas: Flow<List<Notas>> = nota.obtenerTodasLasNotas()

    suspend fun notaById(id: Int): Notas? {
        return nota.obtenerNotaPorId(id)
    }

    suspend fun insertar(newNota: Notas){
        nota.insertarNota(newNota)
    }

    suspend fun deleteNota(deleteNota: Notas){
        nota.eliminarNota(deleteNota)
    }

    suspend fun update(updateNota: Notas){
        nota.actualizarNota(updateNota)
    }
}