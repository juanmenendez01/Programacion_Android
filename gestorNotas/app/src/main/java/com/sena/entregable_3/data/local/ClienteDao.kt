package com.sena.entregable_3.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import androidx.room.OnConflictStrategy
import androidx.room.Transaction
import androidx.room.Update

@Dao
interface ClienteDao {

    @Update
    suspend fun update(cliente: Cliente)

    @Query("DELETE FROM Cliente WHERE id = :id")
    suspend fun deleteById(id: Int)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cliente: Cliente)

    @Query("SELECT * FROM Cliente ORDER BY id DESC")
    fun getAll(): Flow<List<Cliente>>

    @Query("SELECT * FROM Cliente WHERE id = :id ORDER BY id DESC ")
    suspend fun getClienteById(id: Int): Cliente?

    @Transaction
    @Query("SELECT * FROM Cliente WHERE id = :idCliente ORDER BY id DESC ")
    fun getUserNotas(idCliente: Int): Flow<ClienteConNotas>


}