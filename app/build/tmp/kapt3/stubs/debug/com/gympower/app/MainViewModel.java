package com.gympower.app;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fJ$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\n\u0012\u0004\u0012\u00020\u00130\u001aJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\nJ$\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!J\u001c\u0010\"\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130!R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/gympower/app/MainViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "clienteDao", "Lcom/gympower/app/data/ClienteDao;", "clientes", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/gympower/app/data/Cliente;", "getClientes", "()Lkotlinx/coroutines/flow/Flow;", "consulta", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "pagoDao", "Lcom/gympower/app/data/PagoDao;", "buscar", "", "texto", "cargarCliente", "Lkotlinx/coroutines/Job;", "id", "", "onResult", "Lkotlin/Function1;", "eliminar", "cliente", "guardar", "esEdicion", "", "onDone", "Lkotlin/Function0;", "registrarPago", "app_debug"})
public final class MainViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.gympower.app.data.ClienteDao clienteDao = null;
    @org.jetbrains.annotations.NotNull()
    private final com.gympower.app.data.PagoDao pagoDao = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> consulta = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.gympower.app.data.Cliente>> clientes = null;
    
    public MainViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.gympower.app.data.Cliente>> getClientes() {
        return null;
    }
    
    public final void buscar(@org.jetbrains.annotations.NotNull()
    java.lang.String texto) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job cargarCliente(long id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.gympower.app.data.Cliente, kotlin.Unit> onResult) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job guardar(@org.jetbrains.annotations.NotNull()
    com.gympower.app.data.Cliente cliente, boolean esEdicion, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job eliminar(@org.jetbrains.annotations.NotNull()
    com.gympower.app.data.Cliente cliente) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job registrarPago(@org.jetbrains.annotations.NotNull()
    com.gympower.app.data.Cliente cliente, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
        return null;
    }
}