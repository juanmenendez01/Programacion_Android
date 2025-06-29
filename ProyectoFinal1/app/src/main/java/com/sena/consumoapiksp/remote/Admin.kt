package com.sena.consumoapiksp.remote

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Admin(
    val Correo: String,
    val Contrasena: String,
)
