# Gym Power

Aplicación Android sencilla para administrar clientes y pagos mensuales de un gimnasio.

## Funcionalidades

- Alta y edición de clientes con nombre, teléfono, mensualidad, fecha y estado.
- Eliminación de clientes y sus pagos asociados.
- Registro de pago con la fecha actual y asociación al cliente.
- Búsqueda de clientes por nombre.
- Consulta de pagos registrados por fecha mediante `DatePicker`.
- Lista principal con `RecyclerView`, estado de pago y acciones rápidas.
- Cuenta regresiva de la mensualidad: 30 días desde la fecha del último pago.

## Tecnología

- Kotlin 2.0.21
- Android Gradle Plugin 8.7.3
- Android SDK 35, mínimo SDK 24
- XML + Material Design 3
- Room 2.6.1
- MVVM ligero con `AndroidViewModel` y Kotlin Flow

## Estructura principal

```text
app/src/main/java/com/gympower/app/
	data/
		AppDatabase.kt
		Cliente.kt
		ClienteDao.kt
		Pago.kt
		PagoDao.kt
	ClienteAdapter.kt
	ClienteFormActivity.kt
	MainActivity.kt
	MainViewModel.kt
	PagoAdapter.kt
	PagosActivity.kt
	PagosViewModel.kt
	util/DateUtils.kt
app/src/main/res/layout/
	activity_main.xml
	activity_cliente_form.xml
	activity_pagos.xml
	item_cliente.xml
```

## Base de datos

`Cliente` contiene `id`, `nombre`, `telefono`, `montoMensualidad`, `fechaPago` y `estadoPago`.
`Pago` contiene `id`, `clienteId`, `monto` y `fechaPago`, con una clave foránea que elimina pagos al eliminar su cliente.

Las fechas se guardan en formato interno `yyyy-MM-dd`, lo que permite consultar directamente por fecha. La interfaz las muestra como `dd/MM/yyyy`.

## Cuenta regresiva de mensualidad

La vigencia se calcula desde `fechaPago` y dura 30 días de forma inclusiva. El día del pago se muestran 30 días; después la cuenta baja diariamente. Cuando llega a cero se muestra `Mensualidad vencida`. Al registrar un nuevo pago, la fecha se actualiza al día actual y la cuenta vuelve a comenzar en 30 días.

## Abrir y ejecutar

1. Instala Android Studio Hedgehog o una versión posterior.
2. Abre la carpeta raíz `Gym_Power` desde Android Studio.
3. Acepta la sincronización de Gradle e instala Android SDK 35 si Android Studio lo solicita.
4. Ejecuta la configuración `app` en un emulador o dispositivo Android con API 24 o superior.

Desde Android Studio también puedes usar `Build > Make Project` y luego `Run`.

Si existe un Gradle Wrapper generado por Android Studio, la compilación desde terminal es:

```powershell
./gradlew.bat :app:assembleDebug
```

## Estado del desarrollo

Consulta [PROGRESO.md](PROGRESO.md) para ver la bitácora de cambios y validaciones realizadas por la IA.