package com.sena.entregable_3.data.local

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity(tableName = "notas",
    foreignKeys = [
        ForeignKey(
            entity = Cliente::class,
            parentColumns = ["id"],
            childColumns = ["idCliente"],
            onDelete = ForeignKey.CASCADE
        )
    ],
    indices = [Index("idCliente")]
)
data class Notas (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val contenido: String,
    val fecha: String = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date()),
    val idCliente: Int
)

