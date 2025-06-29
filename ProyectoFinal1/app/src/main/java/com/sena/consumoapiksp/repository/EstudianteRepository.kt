package com.sena.consumoapiksp.repository

import android.util.Log
import com.sena.consumoapiksp.model.EstudianteConNota
import com.sena.consumoapiksp.model.EstudianteLocal
import com.sena.consumoapiksp.model.NotaLocal
import com.sena.consumoapiksp.model.dao.EstudianteDao
import com.sena.consumoapiksp.remote.Estudiante
import com.sena.consumoapiksp.remote.EstudianteApi
import javax.inject.Inject

class EstudianteRepository @Inject constructor(
    private val api: EstudianteApi,
    private val local: EstudianteDao
) {
    suspend fun getAllEstudiantesLocal(): List<EstudianteConNota> {
        return local.obtenerTodosConNota()
    }

    suspend fun createEstudiantes(estudiante: Estudiante) {
        try {
            api.createEstudiantes(estudiante)
        } catch (e: Exception) {
            Log.e("EstudianteRepo", "Error al crear en API remota: ${e.localizedMessage}")
        }

        val estudianteLocal = EstudianteLocal(
            idEstudiante = estudiante.IdEstudiante,
            nombreEstudiante = estudiante.NombreEstudiante,
            programaEstudiante = estudiante.ProgramaEstudiante
        )

        val notaLocal = NotaLocal(
            idEstudiante = estudiante.IdEstudiante,
            notaFinal = estudiante.NotaEstudiante
        )

        try {
            local.insert(estudianteLocal)
            local.insertNota(notaLocal)
            Log.d("EstudianteRepo", "Guardado local exitoso")
        } catch (e: Exception) {
            Log.e("EstudianteRepo", "Error al guardar local: ${e.localizedMessage}")
        }
    }

    suspend fun deleteEstudiantes(id: Int) {
        try {
            api.deleteEstudiantes(id)
        } catch (e: Exception) {
            Log.e("EstudianteRepo", "Error al eliminar en API remota: ${e.localizedMessage}")

        }

        try {
            local.deleteById(id)
            Log.d("EstudianteRepo", "Eliminado localmente con éxito")
        } catch (e: Exception) {
            Log.e("EstudianteRepo", "Error al eliminar local: ${e.localizedMessage}")
        }
    }

    suspend fun updateEstudiantes(id: Int, estudiante: Estudiante) {
        val estudianteLocal = EstudianteLocal(
            idEstudiante = estudiante.IdEstudiante,
            nombreEstudiante = estudiante.NombreEstudiante,
            programaEstudiante = estudiante.ProgramaEstudiante
        )

        val notaLocal = NotaLocal(
            idEstudiante = estudiante.IdEstudiante,
            notaFinal = estudiante.NotaEstudiante
        )

        try {
            api.updateEstudiantes(id, estudiante)
        } catch (e: Exception) {
            Log.e("EstudianteRepo", "Error al actualizar remoto: ${e.localizedMessage}")
        } finally {
            local.update(estudianteLocal)
            local.insertNota(notaLocal)
        }
    }
}
