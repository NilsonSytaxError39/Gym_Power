package com.gympower.app.data;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u000b\u001a\u00020\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/gympower/app/data/PagoDao;", "", "insertar", "", "pago", "Lcom/gympower/app/data/Pago;", "(Lcom/gympower/app/data/Pago;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observarPagosConClientePorFecha", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/gympower/app/data/PagoConCliente;", "fecha", "", "app_debug"})
@androidx.room.Dao()
public abstract interface PagoDao {
    
    @androidx.room.Query(value = "SELECT pagos.*, clientes.nombre AS nombreCliente FROM pagos INNER JOIN clientes ON clientes.id = pagos.clienteId WHERE pagos.fechaPago = :fecha ORDER BY clientes.nombre COLLATE NOCASE ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.gympower.app.data.PagoConCliente>> observarPagosConClientePorFecha(@org.jetbrains.annotations.NotNull()
    java.lang.String fecha);
    
    @androidx.room.Insert()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertar(@org.jetbrains.annotations.NotNull()
    com.gympower.app.data.Pago pago, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}