package com.gympower.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.gympower.app.data.AppDatabase
import com.gympower.app.data.Cliente
import com.gympower.app.data.Pago
import com.gympower.app.util.DateUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val clienteDao = AppDatabase.obtener(application).clienteDao()
    private val pagoDao = AppDatabase.obtener(application).pagoDao()
    private val consulta = MutableStateFlow("")

    val clientes: Flow<List<Cliente>> = consulta.flatMapLatest { texto ->
        if (texto.isBlank()) clienteDao.observarTodos() else clienteDao.buscarPorNombre(texto.trim())
    }

    fun buscar(texto: String) {
        consulta.value = texto
    }

    fun cargarCliente(id: Long, onResult: (Cliente?) -> Unit) = viewModelScope.launch {
        onResult(clienteDao.obtenerPorId(id))
    }

    fun guardar(cliente: Cliente, esEdicion: Boolean, onDone: () -> Unit) = viewModelScope.launch {
        if (esEdicion) clienteDao.actualizar(cliente) else clienteDao.insertar(cliente)
        onDone()
    }

    fun eliminar(cliente: Cliente) = viewModelScope.launch {
        clienteDao.eliminar(cliente)
    }

    fun registrarPago(cliente: Cliente, onDone: () -> Unit) = viewModelScope.launch {
        val fecha = DateUtils.hoy()
        clienteDao.actualizar(cliente.copy(fechaPago = fecha, estadoPago = "PAGADO"))
        pagoDao.insertar(Pago(clienteId = cliente.id, monto = cliente.montoMensualidad, fechaPago = fecha))
        onDone()
    }
}
