package com.gympower.app;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/gympower/app/PagosActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/gympower/app/PagoAdapter;", "binding", "Lcom/gympower/app/databinding/ActivityPagosBinding;", "fechaSeleccionada", "", "pagosJob", "Lkotlinx/coroutines/Job;", "viewModel", "Lcom/gympower/app/PagosViewModel;", "getViewModel", "()Lcom/gympower/app/PagosViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "actualizarFecha", "", "mostrarSelectorFecha", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class PagosActivity extends androidx.appcompat.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private com.gympower.app.databinding.ActivityPagosBinding binding;
    @org.jetbrains.annotations.NotNull()
    private final com.gympower.app.PagoAdapter adapter = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String fechaSeleccionada;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job pagosJob;
    
    public PagosActivity() {
        super();
    }
    
    private final com.gympower.app.PagosViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void actualizarFecha() {
    }
    
    private final void mostrarSelectorFecha() {
    }
}