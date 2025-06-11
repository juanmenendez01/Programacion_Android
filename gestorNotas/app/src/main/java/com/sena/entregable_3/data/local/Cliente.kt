package com.sena.entregable_3.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Cliente")
data class Cliente(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val correo: String
)