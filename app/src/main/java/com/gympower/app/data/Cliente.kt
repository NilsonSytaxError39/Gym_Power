package com.gympower.app.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")
data class Cliente(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombre: String,
    val telefono: String,
    val montoMensualidad: Double,
    val fechaPago: String,
    val estadoPago: String
)
