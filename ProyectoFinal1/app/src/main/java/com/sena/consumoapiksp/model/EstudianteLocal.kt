package com.sena.consumoapiksp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiantes")
data class EstudianteLocal(
    @PrimaryKey
    val idEstudiante: Int,
    val nombreEstudiante: String,
    val programaEstudiante: String,
)
