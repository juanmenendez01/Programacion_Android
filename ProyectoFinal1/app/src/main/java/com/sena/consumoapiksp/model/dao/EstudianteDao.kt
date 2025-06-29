package com.sena.consumoapiksp.model.dao

import androidx.room.*
import com.sena.consumoapiksp.model.EstudianteConNota
import com.sena.consumoapiksp.model.EstudianteLocal
import com.sena.consumoapiksp.model.NotaLocal

@Dao
interface EstudianteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(estudiante: EstudianteLocal): Long

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNota(nota: NotaLocal): Long

    @Transaction
    @Query("SELECT * FROM estudiantes")
    suspend fun obtenerTodosConNota(): List<EstudianteConNota>

    @Query("SELECT * FROM estudiantes WHERE idEstudiante = :id")
    suspend fun obtenerPorId(id: Int): EstudianteLocal?

    @Update
    suspend fun update(estudiante: EstudianteLocal): Int

    @Query("DELETE FROM estudiantes WHERE idEstudiante = :id")
    suspend fun deleteById(id: Int): Int
}
