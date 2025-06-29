package com.sena.consumoapiksp.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Estudiante(
    val IdEstudiante: Int,
    val NombreEstudiante: String,
    val ProgramaEstudiante: String,
    val NotaEstudiante: Float

)