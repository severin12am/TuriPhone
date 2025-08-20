package com.turi.languagelearning.data.local.dao;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.CoroutinesRoom;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.SharedSQLiteStatement;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.turi.languagelearning.data.local.entity.UserEntity;
import java.lang.Class;
import java.lang.Exception;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.processing.Generated;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.flow.Flow;

@Generated("androidx.room.RoomProcessor")
@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<UserEntity> __insertionAdapterOfUserEntity;

  private final EntityDeletionOrUpdateAdapter<UserEntity> __deletionAdapterOfUserEntity;

  private final EntityDeletionOrUpdateAdapter<UserEntity> __updateAdapterOfUserEntity;

  private final SharedSQLiteStatement __preparedStmtOfDeleteAllUsers;

  private final SharedSQLiteStatement __preparedStmtOfLogoutAllUsers;

  public UserDao_Impl(@NonNull final RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUserEntity = new EntityInsertionAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "INSERT OR REPLACE INTO `users` (`id`,`email`,`motherLanguage`,`targetLanguage`,`totalMinutes`,`isAuthenticated`,`lastSyncTime`) VALUES (?,?,?,?,?,?,?)";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserEntity entity) {
        statement.bindString(1, entity.getId());
        if (entity.getEmail() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmail());
        }
        statement.bindString(3, entity.getMotherLanguage());
        statement.bindString(4, entity.getTargetLanguage());
        statement.bindLong(5, entity.getTotalMinutes());
        final int _tmp = entity.isAuthenticated() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getLastSyncTime());
      }
    };
    this.__deletionAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "DELETE FROM `users` WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserEntity entity) {
        statement.bindString(1, entity.getId());
      }
    };
    this.__updateAdapterOfUserEntity = new EntityDeletionOrUpdateAdapter<UserEntity>(__db) {
      @Override
      @NonNull
      protected String createQuery() {
        return "UPDATE OR ABORT `users` SET `id` = ?,`email` = ?,`motherLanguage` = ?,`targetLanguage` = ?,`totalMinutes` = ?,`isAuthenticated` = ?,`lastSyncTime` = ? WHERE `id` = ?";
      }

      @Override
      protected void bind(@NonNull final SupportSQLiteStatement statement,
          @NonNull final UserEntity entity) {
        statement.bindString(1, entity.getId());
        if (entity.getEmail() == null) {
          statement.bindNull(2);
        } else {
          statement.bindString(2, entity.getEmail());
        }
        statement.bindString(3, entity.getMotherLanguage());
        statement.bindString(4, entity.getTargetLanguage());
        statement.bindLong(5, entity.getTotalMinutes());
        final int _tmp = entity.isAuthenticated() ? 1 : 0;
        statement.bindLong(6, _tmp);
        statement.bindLong(7, entity.getLastSyncTime());
        statement.bindString(8, entity.getId());
      }
    };
    this.__preparedStmtOfDeleteAllUsers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "DELETE FROM users";
        return _query;
      }
    };
    this.__preparedStmtOfLogoutAllUsers = new SharedSQLiteStatement(__db) {
      @Override
      @NonNull
      public String createQuery() {
        final String _query = "UPDATE users SET isAuthenticated = 0";
        return _query;
      }
    };
  }

  @Override
  public Object insertUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __insertionAdapterOfUserEntity.insert(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __deletionAdapterOfUserEntity.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object updateUser(final UserEntity user, final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        __db.beginTransaction();
        try {
          __updateAdapterOfUserEntity.handle(user);
          __db.setTransactionSuccessful();
          return Unit.INSTANCE;
        } finally {
          __db.endTransaction();
        }
      }
    }, $completion);
  }

  @Override
  public Object deleteAllUsers(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfDeleteAllUsers.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfDeleteAllUsers.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object logoutAllUsers(final Continuation<? super Unit> $completion) {
    return CoroutinesRoom.execute(__db, true, new Callable<Unit>() {
      @Override
      @NonNull
      public Unit call() throws Exception {
        final SupportSQLiteStatement _stmt = __preparedStmtOfLogoutAllUsers.acquire();
        try {
          __db.beginTransaction();
          try {
            _stmt.executeUpdateDelete();
            __db.setTransactionSuccessful();
            return Unit.INSTANCE;
          } finally {
            __db.endTransaction();
          }
        } finally {
          __preparedStmtOfLogoutAllUsers.release(_stmt);
        }
      }
    }, $completion);
  }

  @Override
  public Object getUserById(final String userId,
      final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, userId);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMotherLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "motherLanguage");
          final int _cursorIndexOfTargetLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "targetLanguage");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalMinutes");
          final int _cursorIndexOfIsAuthenticated = CursorUtil.getColumnIndexOrThrow(_cursor, "isAuthenticated");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpMotherLanguage;
            _tmpMotherLanguage = _cursor.getString(_cursorIndexOfMotherLanguage);
            final String _tmpTargetLanguage;
            _tmpTargetLanguage = _cursor.getString(_cursorIndexOfTargetLanguage);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final boolean _tmpIsAuthenticated;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAuthenticated);
            _tmpIsAuthenticated = _tmp != 0;
            final long _tmpLastSyncTime;
            _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            _result = new UserEntity(_tmpId,_tmpEmail,_tmpMotherLanguage,_tmpTargetLanguage,_tmpTotalMinutes,_tmpIsAuthenticated,_tmpLastSyncTime);
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

  @Override
  public Object getUserByEmail(final String email,
      final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE email = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindString(_argIndex, email);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMotherLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "motherLanguage");
          final int _cursorIndexOfTargetLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "targetLanguage");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalMinutes");
          final int _cursorIndexOfIsAuthenticated = CursorUtil.getColumnIndexOrThrow(_cursor, "isAuthenticated");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpMotherLanguage;
            _tmpMotherLanguage = _cursor.getString(_cursorIndexOfMotherLanguage);
            final String _tmpTargetLanguage;
            _tmpTargetLanguage = _cursor.getString(_cursorIndexOfTargetLanguage);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final boolean _tmpIsAuthenticated;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAuthenticated);
            _tmpIsAuthenticated = _tmp != 0;
            final long _tmpLastSyncTime;
            _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            _result = new UserEntity(_tmpId,_tmpEmail,_tmpMotherLanguage,_tmpTargetLanguage,_tmpTotalMinutes,_tmpIsAuthenticated,_tmpLastSyncTime);
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

  @Override
  public Object getCurrentUser(final Continuation<? super UserEntity> $completion) {
    final String _sql = "SELECT * FROM users WHERE isAuthenticated = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    final CancellationSignal _cancellationSignal = DBUtil.createCancellationSignal();
    return CoroutinesRoom.execute(__db, false, _cancellationSignal, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMotherLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "motherLanguage");
          final int _cursorIndexOfTargetLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "targetLanguage");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalMinutes");
          final int _cursorIndexOfIsAuthenticated = CursorUtil.getColumnIndexOrThrow(_cursor, "isAuthenticated");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpMotherLanguage;
            _tmpMotherLanguage = _cursor.getString(_cursorIndexOfMotherLanguage);
            final String _tmpTargetLanguage;
            _tmpTargetLanguage = _cursor.getString(_cursorIndexOfTargetLanguage);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final boolean _tmpIsAuthenticated;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAuthenticated);
            _tmpIsAuthenticated = _tmp != 0;
            final long _tmpLastSyncTime;
            _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            _result = new UserEntity(_tmpId,_tmpEmail,_tmpMotherLanguage,_tmpTargetLanguage,_tmpTotalMinutes,_tmpIsAuthenticated,_tmpLastSyncTime);
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

  @Override
  public Flow<UserEntity> getCurrentUserFlow() {
    final String _sql = "SELECT * FROM users WHERE isAuthenticated = 1 LIMIT 1";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return CoroutinesRoom.createFlow(__db, false, new String[] {"users"}, new Callable<UserEntity>() {
      @Override
      @Nullable
      public UserEntity call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfEmail = CursorUtil.getColumnIndexOrThrow(_cursor, "email");
          final int _cursorIndexOfMotherLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "motherLanguage");
          final int _cursorIndexOfTargetLanguage = CursorUtil.getColumnIndexOrThrow(_cursor, "targetLanguage");
          final int _cursorIndexOfTotalMinutes = CursorUtil.getColumnIndexOrThrow(_cursor, "totalMinutes");
          final int _cursorIndexOfIsAuthenticated = CursorUtil.getColumnIndexOrThrow(_cursor, "isAuthenticated");
          final int _cursorIndexOfLastSyncTime = CursorUtil.getColumnIndexOrThrow(_cursor, "lastSyncTime");
          final UserEntity _result;
          if (_cursor.moveToFirst()) {
            final String _tmpId;
            _tmpId = _cursor.getString(_cursorIndexOfId);
            final String _tmpEmail;
            if (_cursor.isNull(_cursorIndexOfEmail)) {
              _tmpEmail = null;
            } else {
              _tmpEmail = _cursor.getString(_cursorIndexOfEmail);
            }
            final String _tmpMotherLanguage;
            _tmpMotherLanguage = _cursor.getString(_cursorIndexOfMotherLanguage);
            final String _tmpTargetLanguage;
            _tmpTargetLanguage = _cursor.getString(_cursorIndexOfTargetLanguage);
            final int _tmpTotalMinutes;
            _tmpTotalMinutes = _cursor.getInt(_cursorIndexOfTotalMinutes);
            final boolean _tmpIsAuthenticated;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfIsAuthenticated);
            _tmpIsAuthenticated = _tmp != 0;
            final long _tmpLastSyncTime;
            _tmpLastSyncTime = _cursor.getLong(_cursorIndexOfLastSyncTime);
            _result = new UserEntity(_tmpId,_tmpEmail,_tmpMotherLanguage,_tmpTargetLanguage,_tmpTotalMinutes,_tmpIsAuthenticated,_tmpLastSyncTime);
          } else {
            _result = null;
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
