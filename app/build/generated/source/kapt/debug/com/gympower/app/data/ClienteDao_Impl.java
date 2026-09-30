package com.gympower.app.data;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Long;
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
public final class ClienteDao_Impl implements ClienteDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Cliente> __insertionAdapterOfCliente;

  private final EntityDeletionOrUpdateAdapter<Cliente> __deletionAdapterOfCliente;

  private final EntityDeletionOrUpdateAdapter<Cliente> __updateAdapterOfCliente;

  public ClienteDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfCliente = new EntityInsertionAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR ABORT INTO `clientes` (`id`,`nombre`,`telefono`,`montoMensualidad`,`fechaPago`,`estadoPago`) VALUES (nullif(?, 0),?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        if (entity.getTelefono() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTelefono());
        }
        statement.bindDouble(4, entity.getMontoMensualidad());
        if (entity.getFechaPago() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getFechaPago());
        }
        if (entity.getEstadoPago() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEstadoPago());
        }
      }
    };
    this.__deletionAdapterOfCliente = new EntityDeletionOrUpdateAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `clientes` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getId());
      }
    };
    this.__updateAdapterOfCliente = new EntityDeletionOrUpdateAdapter<Cliente>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `clientes` SET `id` = ?,`nombre` = ?,`telefono` = ?,`montoMensualidad` = ?,`fechaPago` = ?,`estadoPago` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final Cliente entity) {
        statement.bindLong(1, entity.getId());
        if (entity.getNombre() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getNombre());
        }
        if (entity.getTelefono() == null) {
          statement.bindNull(3);
        } else {
          statement.bindString(3, entity.getTelefono());
        }
        statement.bindDouble(4, entity.getMontoMensualidad());
        if (entity.getFechaPago() == null) {
          statement.bindNull(5);
        } else {
          statement.bindString(5, entity.getFechaPago());
        }
        if (entity.getEstadoPago() == null) {
          statement.bindNull(6);
        } else {
          statement.bindString(6, entity.getEstadoPago());
        }
        statement.bindLong(7, entity.getId());
      }
    };
  }

  @Override
  public Object insertar(final Cliente cliente, final Continuation<? super Long> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Long>() {
      @Override
      @NonNull
      public Long call() throws Exception {
        __db.beginTransaction();
        try {
          final Long _result = __insertionAdapterOfCliente.insertAndReturnId(cliente);
          __db.setTransactionSuccessful();
          return _result;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object eliminar(final Cliente cliente, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfCliente.handle(cliente);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object actualizar(final Cliente cliente, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfCliente.handle(cliente);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Flow<List<Cliente>> observarTodos() {
    final String _sql = "SELECT * FROM clientes ORDER BY nombre COLLATE NOCASE ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"clientes"}, new Callable<List<Cliente>>() {
      @Override
      @NonNull
      public List<Cliente> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfMontoMensualidad = CursorUtil.getColumnIndexOrThrow(_cursor, "montoMensualidad");
          final int _cursorIndexOfFechaPago = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaPago");
          final int _cursorIndexOfEstadoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoPago");
          final List<Cliente> _result = new ArrayList<Cliente>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Cliente _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final double _tmpMontoMensualidad;
            _tmpMontoMensualidad = _cursor.getDouble(_cursorIndexOfMontoMensualidad);
            final String _tmpFechaPago;
            if (_cursor.isNull(_cursorIndexOfFechaPago)) {
              _tmpFechaPago = null;
            } else {
              _tmpFechaPago = _cursor.getString(_cursorIndexOfFechaPago);
            }
            final String _tmpEstadoPago;
            if (_cursor.isNull(_cursorIndexOfEstadoPago)) {
              _tmpEstadoPago = null;
            } else {
              _tmpEstadoPago = _cursor.getString(_cursorIndexOfEstadoPago);
            }
            _item = new Cliente(_tmpId,_tmpNombre,_tmpTelefono,_tmpMontoMensualidad,_tmpFechaPago,_tmpEstadoPago);
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

  @Override
  public Flow<List<Cliente>> buscarPorNombre(final String consulta) {
    final String _sql = "SELECT * FROM clientes WHERE nombre LIKE '%' || ? || '%' ORDER BY nombre COLLATE NOCASE ASC";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (consulta == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, consulta);
    }
    return CoroutinesRoom.createFlow(__db, false, new String[] {"clientes"}, new Callable<List<Cliente>>() {
      @Override
      @NonNull
      public List<Cliente> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfMontoMensualidad = CursorUtil.getColumnIndexOrThrow(_cursor, "montoMensualidad");
          final int _cursorIndexOfFechaPago = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaPago");
          final int _cursorIndexOfEstadoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoPago");
          final List<Cliente> _result = new ArrayList<Cliente>(_cursor.getCount());
          while (_cursor.moveToNext()) {
            final Cliente _item;
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final double _tmpMontoMensualidad;
            _tmpMontoMensualidad = _cursor.getDouble(_cursorIndexOfMontoMensualidad);
            final String _tmpFechaPago;
            if (_cursor.isNull(_cursorIndexOfFechaPago)) {
              _tmpFechaPago = null;
            } else {
              _tmpFechaPago = _cursor.getString(_cursorIndexOfFechaPago);
            }
            final String _tmpEstadoPago;
            if (_cursor.isNull(_cursorIndexOfEstadoPago)) {
              _tmpEstadoPago = null;
            } else {
              _tmpEstadoPago = _cursor.getString(_cursorIndexOfEstadoPago);
            }
            _item = new Cliente(_tmpId,_tmpNombre,_tmpTelefono,_tmpMontoMensualidad,_tmpFechaPago,_tmpEstadoPago);
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

  @Override
  public Object obtenerPorId(final long id, final Continuation<? super Cliente> $completion) {
    final String _sql = "SELECT * FROM clientes WHERE id = ? LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<Cliente>() {
      @Override
      @Nullable
      public Cliente call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfNombre = CursorUtil.getColumnIndexOrThrow(_cursor, "nombre");
          final int _cursorIndexOfTelefono = CursorUtil.getColumnIndexOrThrow(_cursor, "telefono");
          final int _cursorIndexOfMontoMensualidad = CursorUtil.getColumnIndexOrThrow(_cursor, "montoMensualidad");
          final int _cursorIndexOfFechaPago = CursorUtil.getColumnIndexOrThrow(_cursor, "fechaPago");
          final int _cursorIndexOfEstadoPago = CursorUtil.getColumnIndexOrThrow(_cursor, "estadoPago");
          final Cliente _result;
          if (_cursor.moveToFirst()) {
            final long _tmpId;
            _tmpId = _cursor.getLong(_cursorIndexOfId);
            final String _tmpNombre;
            if (_cursor.isNull(_cursorIndexOfNombre)) {
              _tmpNombre = null;
            } else {
              _tmpNombre = _cursor.getString(_cursorIndexOfNombre);
            }
            final String _tmpTelefono;
            if (_cursor.isNull(_cursorIndexOfTelefono)) {
              _tmpTelefono = null;
            } else {
              _tmpTelefono = _cursor.getString(_cursorIndexOfTelefono);
            }
            final double _tmpMontoMensualidad;
            _tmpMontoMensualidad = _cursor.getDouble(_cursorIndexOfMontoMensualidad);
            final String _tmpFechaPago;
            if (_cursor.isNull(_cursorIndexOfFechaPago)) {
              _tmpFechaPago = null;
            } else {
              _tmpFechaPago = _cursor.getString(_cursorIndexOfFechaPago);
            }
            final String _tmpEstadoPago;
            if (_cursor.isNull(_cursorIndexOfEstadoPago)) {
              _tmpEstadoPago = null;
            } else {
              _tmpEstadoPago = _cursor.getString(_cursorIndexOfEstadoPago);
            }
            _result = new Cliente(_tmpId,_tmpNombre,_tmpTelefono,_tmpMontoMensualidad,_tmpFechaPago,_tmpEstadoPago);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
          _statement.release();
        }
      }
    }, $completion);
  }

  @NonNull
  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
