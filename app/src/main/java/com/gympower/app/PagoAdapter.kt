package com.gympower.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gympower.app.data.PagoConCliente
import java.text.NumberFormat
import java.util.Locale

class PagoAdapter : RecyclerView.Adapter<PagoAdapter.PagoViewHolder>() {
    private var pagos = emptyList<PagoConCliente>()
    private val moneda = NumberFormat.getCurrencyInstance(Locale.getDefault())

    fun actualizar(lista: List<PagoConCliente>) {
        pagos = lista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PagoViewHolder = PagoViewHolder(
        LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_2, parent, false)
    )

    override fun onBindViewHolder(holder: PagoViewHolder, position: Int) = holder.bind(pagos[position])
    override fun getItemCount(): Int = pagos.size

    class PagoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val titulo = view.findViewById<TextView>(android.R.id.text1)
        private val detalle = view.findViewById<TextView>(android.R.id.text2)

        fun bind(pago: PagoConCliente) {
            titulo.text = pago.nombreCliente
            detalle.text = "Pago registrado: ${NumberFormat.getCurrencyInstance(Locale.getDefault()).format(pago.monto)}"
        }
    }
}
