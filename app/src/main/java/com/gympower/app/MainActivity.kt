package com.gympower.app

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.gympower.app.data.Cliente
import com.gympower.app.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ClienteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = ClienteAdapter(::editarCliente, ::confirmarEliminar, ::registrarPago)
        binding.rvClientes.layoutManager = LinearLayoutManager(this)
        binding.rvClientes.adapter = adapter
        binding.etBuscar.doAfterTextChanged { viewModel.buscar(it?.toString().orEmpty()) }
        binding.fabAgregar.setOnClickListener { startActivity(Intent(this, ClienteFormActivity::class.java)) }
        binding.btnPagos.setOnClickListener { startActivity(Intent(this, PagosActivity::class.java)) }
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.clientes.collectLatest {
                    adapter.actualizar(it)
                    binding.tvResumen.text = "${it.size} cliente(s) registrado(s)"
                }
            }
        }
    }

    private fun editarCliente(cliente: Cliente) {
        startActivity(Intent(this, ClienteFormActivity::class.java).putExtra(ClienteFormActivity.EXTRA_ID, cliente.id))
    }

    private fun confirmarEliminar(cliente: Cliente) {
        AlertDialog.Builder(this)
            .setTitle("Eliminar cliente")
            .setMessage("¿Eliminar a ${cliente.nombre} y sus pagos registrados?")
            .setNegativeButton("Cancelar", null)
            .setPositiveButton("Eliminar") { _, _ -> viewModel.eliminar(cliente) }
            .show()
    }

    private fun registrarPago(cliente: Cliente) {
        AlertDialog.Builder(this)
            .setTitle("Registrar pago")
            .setMessage("¿Confirmar pago de la mensualidad de ${cliente.nombre}?")
            .setNegativeButton("Cancelar", null)
            .setPositiveButton("Confirmar") { _, _ -> viewModel.registrarPago(cliente) {} }
            .show()
    }
}
