package com.sena.consumoapiksp.model.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.sena.consumoapiksp.model.EstudianteLocal
import com.sena.consumoapiksp.model.NotaLocal

@Dao
interface NotaDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(nota: NotaLocal): Long

    @Query("SELECT * FROM notas WHERE idEstudiante = :idEstudiante")
    suspend fun obtenerPorEstudiante(idEstudiante: Int): NotaLocal?

    @Update
    suspend fun actualizar(nota: NotaLocal): Int

    @Query("DELETE FROM notas WHERE idEstudiante = :idEstudiante")
    suspend fun eliminarPorEstudiante(idEstudiante: Int): Int
}