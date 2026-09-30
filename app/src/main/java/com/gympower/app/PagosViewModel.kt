package com.gympower.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gympower.app.data.AppDatabase
import com.gympower.app.data.PagoConCliente
import kotlinx.coroutines.flow.Flow

class PagosViewModel(application: Application) : AndroidViewModel(application) {
    private val pagoDao = AppDatabase.obtener(application).pagoDao()

    fun pagosPorFecha(fecha: String): Flow<List<PagoConCliente>> =
        pagoDao.observarPagosConClientePorFecha(fecha)
}
