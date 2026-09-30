package com.gympower.app.data

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pagos",
    foreignKeys = [
        ForeignKey(
            entity = Cliente::class,
            parentColumns = ["id"],
            childColumns = ["clienteId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class Pago(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val clienteId: Long,
    val monto: Double,
    val fechaPago: String
)
