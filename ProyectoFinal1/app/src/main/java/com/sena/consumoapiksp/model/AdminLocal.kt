package com.sena.consumoapiksp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admin")
data class AdminLocal(
    @PrimaryKey val correo: String,
    val contrasena: String
)
