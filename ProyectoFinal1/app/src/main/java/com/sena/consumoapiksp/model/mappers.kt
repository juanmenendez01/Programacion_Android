package com.sena.consumoapiksp.model

import com.sena.consumoapiksp.remote.Estudiante

fun EstudianteConNota.toRemoto(): Estudiante {
    return Estudiante(
        IdEstudiante = estudiante.idEstudiante,
        NombreEstudiante = estudiante.nombreEstudiante,
        ProgramaEstudiante = estudiante.programaEstudiante,
        NotaEstudiante = nota?.notaFinal ?: 0f
    )
}
