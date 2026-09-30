package com.gympower.app

import android.app.DatePickerDialog
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gympower.app.databinding.ActivityPagosBinding
import com.gympower.app.util.DateUtils
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.Job
import java.util.Calendar

class PagosActivity : AppCompatActivity() {
    private val viewModel: PagosViewModel by viewModels()
    private lateinit var binding: ActivityPagosBinding
    private val adapter = PagoAdapter()
    private var fechaSeleccionada = DateUtils.hoy()
    private var pagosJob: Job? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.rvPagos.layoutManager = LinearLayoutManager(this)
        binding.rvPagos.adapter = adapter
        binding.toolbar.setNavigationOnClickListener { finish() }
        binding.btnFecha.setOnClickListener { mostrarSelectorFecha() }
        actualizarFecha()
    }

    private fun actualizarFecha() {
        binding.tvFechaSeleccionada.text = "Pagos del ${DateUtils.visible(fechaSeleccionada)}"
        pagosJob?.cancel()
        pagosJob = lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.pagosPorFecha(fechaSeleccionada).collectLatest {
                    adapter.actualizar(it)
                    binding.tvSinPagos.visibility = if (it.isEmpty()) android.view.View.VISIBLE else android.view.View.GONE
                }
            }
        }
    }

    private fun mostrarSelectorFecha() {
        val calendario = Calendar.getInstance()
        DatePickerDialog(this, { _, anio, mes, dia ->
            fechaSeleccionada = DateUtils.interno(dia, mes, anio)
            actualizarFecha()
        }, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH)).show()
    }
}
