package com.gympower.app.util

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object DateUtils {
    private const val FORMATO_INTERNO = "yyyy-MM-dd"
    private const val FORMATO_VISIBLE = "dd/MM/yyyy"
    private const val DIAS_MENSUALIDAD = 30L

    fun hoy(): String = SimpleDateFormat(FORMATO_INTERNO, Locale.US).format(Date())

    fun visible(fecha: String): String = try {
        val date = SimpleDateFormat(FORMATO_INTERNO, Locale.US).parse(fecha)
        SimpleDateFormat(FORMATO_VISIBLE, Locale.getDefault()).format(date!!)
    } catch (_: Exception) {
        fecha
    }

    fun interno(dia: Int, mes: Int, anio: Int): String =
        String.format(Locale.US, "%04d-%02d-%02d", anio, mes + 1, dia)

    fun diasRestantes(fechaPago: String, fechaActual: String = hoy()): Long? = try {
        val formato = SimpleDateFormat(FORMATO_INTERNO, Locale.US).apply { isLenient = false }
        val inicio = formato.parse(fechaPago) ?: return null
        val actual = formato.parse(fechaActual) ?: return null
        val calendarioFin = java.util.Calendar.getInstance().apply {
            time = inicio
            add(java.util.Calendar.DAY_OF_MONTH, (DIAS_MENSUALIDAD - 1).toInt())
        }
        val diferencia = (calendarioFin.timeInMillis - actual.time) / (24 * 60 * 60 * 1000)
        (diferencia + 1).coerceAtLeast(0)
    } catch (_: Exception) {
        null
    }
}
