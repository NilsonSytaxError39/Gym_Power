package com.gympower.app

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.gympower.app.data.Cliente
import com.gympower.app.util.DateUtils
import java.text.NumberFormat
import java.util.Locale

class ClienteAdapter(
    private val onEditar: (Cliente) -> Unit,
    private val onEliminar: (Cliente) -> Unit,
    private val onPagar: (Cliente) -> Unit
) : RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>() {
    private var clientes = emptyList<Cliente>()
    private val moneda = NumberFormat.getCurrencyInstance(Locale.getDefault())

    fun actualizar(lista: List<Cliente>) {
        clientes = lista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClienteViewHolder = ClienteViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_cliente, parent, false)
    )

    override fun onBindViewHolder(holder: ClienteViewHolder, position: Int) = holder.bind(clientes[position])
    override fun getItemCount(): Int = clientes.size

    inner class ClienteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val nombre = view.findViewById<TextView>(R.id.tvNombre)
        private val telefono = view.findViewById<TextView>(R.id.tvTelefono)
        private val monto = view.findViewById<TextView>(R.id.tvMonto)
        private val fecha = view.findViewById<TextView>(R.id.tvFecha)
        private val cuentaRegresiva = view.findViewById<TextView>(R.id.tvCuentaRegresiva)
        private val estado = view.findViewById<TextView>(R.id.tvEstado)
        private val pagar = view.findViewById<MaterialButton>(R.id.btnPagar)

        fun bind(cliente: Cliente) {
            nombre.text = cliente.nombre
            telefono.text = "Teléfono: ${cliente.telefono}"
            monto.text = "Mensualidad: ${moneda.format(cliente.montoMensualidad)}"
            fecha.text = "Último pago: ${DateUtils.visible(cliente.fechaPago)}"
            val diasRestantes = DateUtils.diasRestantes(cliente.fechaPago)
            cuentaRegresiva.text = when {
                diasRestantes == null -> "Vigencia: fecha no válida"
                diasRestantes == 0L -> "Mensualidad vencida"
                diasRestantes == 1L -> "Vigencia: queda 1 día"
                else -> "Vigencia: quedan $diasRestantes días"
            }
            cuentaRegresiva.setTextColor(Color.parseColor(if (diasRestantes != null && diasRestantes <= 3) "#B45309" else "#1565C0"))
            estado.text = cliente.estadoPago
            estado.setTextColor(Color.parseColor(if (cliente.estadoPago == "PAGADO") "#16845B" else "#B45309"))
            pagar.visibility = if (cliente.estadoPago == "PAGADO") View.GONE else View.VISIBLE
            pagar.setOnClickListener { onPagar(cliente) }
            itemView.findViewById<ImageButton>(R.id.btnEditar).setOnClickListener { onEditar(cliente) }
            itemView.findViewById<ImageButton>(R.id.btnEliminar).setOnClickListener { onEliminar(cliente) }
        }
    }
}
