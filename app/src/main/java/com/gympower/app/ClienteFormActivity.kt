package com.gympower.app

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.gympower.app.data.Cliente
import com.gympower.app.databinding.ActivityClienteFormBinding
import com.gympower.app.util.DateUtils
import java.util.Calendar

class ClienteFormActivity : AppCompatActivity() {
    companion object { const val EXTRA_ID = "cliente_id" }
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityClienteFormBinding
    private var clienteExistente: Cliente? = null
    private var fechaInterna = DateUtils.hoy()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteFormBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.spEstado.setAdapter(ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, resources.getStringArray(R.array.estados_pago)))
        binding.spEstado.setText("PENDIENTE", false)
        binding.etFecha.setText(DateUtils.visible(fechaInterna))
        binding.toolbar.setNavigationOnClickListener { finish() }
        binding.etFecha.setOnClickListener { mostrarSelectorFecha() }
        binding.btnGuardar.setOnClickListener { guardar() }
        intent.getLongExtra(EXTRA_ID, -1L).takeIf { it > 0 }?.let { id ->
            viewModel.cargarCliente(id) { cliente -> runOnUiThread { cliente?.let(::mostrarCliente) } }
        }
    }

    private fun mostrarCliente(cliente: Cliente) {
        clienteExistente = cliente
        binding.toolbar.title = "Editar cliente"
        binding.etNombre.setText(cliente.nombre)
        binding.etTelefono.setText(cliente.telefono)
        binding.etMonto.setText(cliente.montoMensualidad.toString())
        fechaInterna = cliente.fechaPago
        binding.etFecha.setText(DateUtils.visible(fechaInterna))
        binding.spEstado.setText(cliente.estadoPago, false)
    }

    private fun mostrarSelectorFecha() {
        val calendario = Calendar.getInstance()
        DatePickerDialog(this, { _, anio, mes, dia ->
            fechaInterna = DateUtils.interno(dia, mes, anio)
            binding.etFecha.setText(DateUtils.visible(fechaInterna))
        }, calendario.get(Calendar.YEAR), calendario.get(Calendar.MONTH), calendario.get(Calendar.DAY_OF_MONTH)).show()
    }

    private fun guardar() {
        val nombre = binding.etNombre.text?.toString()?.trim().orEmpty()
        val telefono = binding.etTelefono.text?.toString()?.trim().orEmpty()
        val monto = binding.etMonto.text?.toString()?.toDoubleOrNull()
        if (nombre.isBlank() || telefono.isBlank() || monto == null || monto <= 0) {
            Toast.makeText(this, "Completa todos los campos correctamente", Toast.LENGTH_SHORT).show()
            return
        }
        val cliente = Cliente(
            id = clienteExistente?.id ?: 0,
            nombre = nombre,
            telefono = telefono,
            montoMensualidad = monto,
            fechaPago = fechaInterna,
            estadoPago = binding.spEstado.text?.toString().orEmpty().ifBlank { "PENDIENTE" }
        )
        viewModel.guardar(cliente, clienteExistente != null) { runOnUiThread { finish() } }
    }
}
