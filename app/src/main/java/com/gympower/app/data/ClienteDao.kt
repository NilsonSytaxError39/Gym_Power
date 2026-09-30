package com.gympower.app.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Query("SELECT * FROM clientes ORDER BY nombre COLLATE NOCASE ASC")
    fun observarTodos(): Flow<List<Cliente>>

    @Query("SELECT * FROM clientes WHERE nombre LIKE '%' || :consulta || '%' ORDER BY nombre COLLATE NOCASE ASC")
    fun buscarPorNombre(consulta: String): Flow<List<Cliente>>

    @Query("SELECT * FROM clientes WHERE id = :id LIMIT 1")
    suspend fun obtenerPorId(id: Long): Cliente?

    @Insert
    suspend fun insertar(cliente: Cliente): Long

    @Update
    suspend fun actualizar(cliente: Cliente)

    @Delete
    suspend fun eliminar(cliente: Cliente)
}
