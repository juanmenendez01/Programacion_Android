package com.sena.entregable_3.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NotasDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertarNota(nota: Notas)

    @Update
    suspend fun actualizarNota(nota: Notas)

    @Delete
    suspend fun eliminarNota(nota: Notas)

    @Query("SELECT * FROM notas ORDER BY id DESC")
    fun obtenerTodasLasNotas(): Flow<List<Notas>>

    @Query("SELECT * FROM notas WHERE id = :id")
    suspend fun obtenerNotaPorId(id: Int): Notas?

    @Transaction
    @Query("DELETE FROM notas WHERE idCliente = :idCliente")
    suspend fun eliminarNotasPorCliente(idCliente: Int)

    @Query("SELECT * FROM notas WHERE idCliente = :idCliente ORDER BY id DESC")
    fun obtenerNotasPorCliente(idCliente: Int): Flow<List<Notas>>
}