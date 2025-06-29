package com.sena.consumoapiksp.model

import androidx.room.Embedded
import androidx.room.Relation

data class EstudianteConNota(
    @Embedded val estudiante: EstudianteLocal,

    @Relation(
        parentColumn = "idEstudiante",
        entityColumn = "idEstudiante"
    )
    val nota: NotaLocal?
)
