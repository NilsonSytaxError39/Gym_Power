package com.gympower.app.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface PagoDao {
    @Query("SELECT pagos.*, clientes.nombre AS nombreCliente FROM pagos INNER JOIN clientes ON clientes.id = pagos.clienteId WHERE pagos.fechaPago = :fecha ORDER BY clientes.nombre COLLATE NOCASE ASC")
    fun observarPagosConClientePorFecha(fecha: String): Flow<List<PagoConCliente>>

    @Insert
    suspend fun insertar(pago: Pago)
}

data class PagoConCliente(
    val id: Long,
    val clienteId: Long,
    val monto: Double,
    val fechaPago: String,
    val nombreCliente: String
)
