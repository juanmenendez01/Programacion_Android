package com.sena.consumoapiksp.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "notas",
    foreignKeys = [
        ForeignKey(
            entity = EstudianteLocal::class,
            parentColumns = ["idEstudiante"],
            childColumns = ["idEstudiante"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("idEstudiante", unique = true)]
)
data class NotaLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idEstudiante: Int,
    val notaFinal: Float
)
