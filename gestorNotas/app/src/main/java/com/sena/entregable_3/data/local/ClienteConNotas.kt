package com.sena.entregable_3.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class ClienteConNotas(
    @Embedded val cliente: Cliente,
    @Relation(
        parentColumn = "id",
        entityColumn = "idCliente"
    )
    val nota: List<Notas>
)
