# Bitácora de desarrollo

Este archivo registra lo que la IA va haciendo en el proyecto Gym Power.

## 2026-09-29

### 1. Revisión inicial

- Se revisó el workspace y se confirmó que solo existía un `README.md`.
- Se definió una app Android nativa con Kotlin, XML, Room y un MVVM ligero.
- Se decidió guardar fechas como `yyyy-MM-dd` para facilitar consultas exactas por fecha.

### 2. Configuración del proyecto

- Se creó el proyecto Gradle Android con módulo `app`.
- Se configuró Kotlin 2.0.21, Android Gradle Plugin 8.7.3, compile SDK 35 y min SDK 24.
- Se agregaron dependencias de AndroidX, Material Design, RecyclerView, Lifecycle y Room.
- Se habilitó ViewBinding.
- Se creó el manifest, tema Material 3, colores, textos y estados de pago.

### 3. Persistencia local

- Se creó la entidad `Cliente` con los datos de registro solicitados.
- Se creó la entidad `Pago` con relación por clave foránea hacia `Cliente`.
- Se implementaron `ClienteDao` y `PagoDao`.
- Se creó `AppDatabase` como singleton Room.
- Se implementaron consultas reactivas con Kotlin Flow para listado, búsqueda y pagos por fecha.

### 4. Lógica de aplicación

- `MainViewModel` gestiona búsqueda, alta, edición, eliminación y registro de pagos.
- Registrar un pago actualiza el cliente a `PAGADO`, asigna la fecha actual y crea un registro histórico en `pagos`.
- `PagosViewModel` expone los pagos asociados a una fecha seleccionada.

### 5. Interfaz

- Se creó la pantalla principal con búsqueda, resumen, `RecyclerView` y botón para agregar.
- Se creó el formulario XML de alta/edición con `DatePicker` y selector de estado.
- Se creó la pantalla de pagos por fecha con `DatePicker`.
- Se implementaron `ClienteAdapter` y `PagoAdapter`.
- Se agregaron confirmaciones para eliminar clientes y registrar pagos.

### 6. Cuenta regresiva de mensualidad

- Se añadió el cálculo de días restantes en `DateUtils`.
- La mensualidad dura 30 días desde `fechaPago`, contando el día del pago.
- La tarjeta de cada cliente muestra `quedan X días`, `queda 1 día` o `Mensualidad vencida`.
- La cuenta se resalta cuando quedan 3 días o menos.
- Registrar un nuevo pago reinicia automáticamente la cuenta a 30 días.

### 7. Documentación

- Se actualizó `README.md` con funcionalidades, dependencias, estructura y pasos para ejecutar.
- Esta bitácora queda como registro incremental del trabajo de la IA.

### 8. Validación

- El análisis del editor no reporta errores en las clases Kotlin principales ni en `app/build.gradle.kts`.
- Se ajustó la pantalla de pagos para cancelar la consulta anterior al cambiar de fecha y evitar coleccionistas duplicados.
- No fue posible ejecutar una compilación local porque el comando `gradle` no está instalado en la máquina actual.
- La compilación debe ejecutarse desde Android Studio, que descargará o utilizará el Gradle Wrapper y las dependencias configuradas.

## Próxima comprobación recomendada

Abrir el proyecto en Android Studio, sincronizar Gradle, ejecutar `Build > Make Project` y probar en un emulador: crear cliente, registrar pago, buscarlo y consultar ese pago desde la pantalla por fecha.
