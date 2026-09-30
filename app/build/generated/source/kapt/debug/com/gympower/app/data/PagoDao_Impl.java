package com.gympower.app.data;

import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class PagoDao_Impl implements PagoDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Pago> __insertionAdapterOfPago;

  public PagoDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfPago = new EntityInsertionAdapter<Pago>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `pagos` (`id`,`clienteId`,`monto`,`fechaPago`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Pago entity) {
        statement.bindLong(1, entity.getId());
        statement.bindLong(2, entity.getClienteId());
        statement.bindDouble(3, entity.getMonto());
        if (entity.getFechaPago() == null) {
          statement.bindNull(4);
        } else {
          statement.bindString(4, entity.getFechaPago());
        }
      }
    };
  }

  @Override
  public Object insertar(final Pago pago, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfPago.insert(pago);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<PagoConCliente>> observarPagosConClientePorFecha(final String fecha) {
    final String _sql = "SELECT pagos.*, clientes.nombre AS nombreCliente FROM pagos INNER JOIN clientes ON clientes.id = pagos.clienteId WHERE pagos.fechaPago = ? ORDER BY clientes.nombre COLLATE NOCASE ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (fecha == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, fecha);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"pagos",
        "clientes"}, new Callable<List<PagoConCliente>>() {
      @Override
      @NonNull
      public List<PagoConCliente> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfClienteId = CursorUtil.getColumnIndexOrThrow(_cursor, "clienteId");
          final int _cursorIndexOfMonto = CursorUtil.getColumnIndexOrThrow(_cursor, "monto");
          final int _cursorIndexOfFechaPago = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaPago");
          final int _cursorIndexOfNombreCliente = CursorUtil.getColumnIndexOrThrow(_cursor, "nombreCliente");
          final List<PagoConCliente> _result = new ArrayList<PagoConCliente>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final PagoConCliente _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final long _tmpClienteId;
            _tmpClienteId = _cursor.getLong(_cursorIndexOfClienteId);
            final double _tmpMonto;
            _tmpMonto = _cursor.getDouble(_cursorIndexOfMonto);
            final String _tmpFechaPago;
            if (_cursor.isNull(_cursorIndexOfFechaPago)) {
              _tmpFechaPago = null;
            } else {
              _tmpFechaPago = _cursor.getString(_cursorIndexOfFechaPago);
            }
            final String _tmpNombreCliente;
            if (_cursor.isNull(_cursorIndexOfNombreCliente)) {
              _tmpNombreCliente = null;
            } else {
              _tmpNombreCliente = _cursor.getString(_cursorIndexOfNombreCliente);
            }
            _item = new PagoConCliente(_tmpId,_tmpClienteId,_tmpMonto,_tmpFechaPago,_tmpNombreCliente);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
