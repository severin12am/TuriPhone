package com.turi.languagelearning.data.local;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import com.turi.languagelearning.data.local.dao.UserDao;
import com.turi.languagelearning.data.local.entity.UserEntity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&\u00a8\u0006\u0005"}, d2 = {"Lcom/turi/languagelearning/data/local/TuriDatabase;", "Landroidx/room/RoomDatabase;", "()V", "userDao", "Lcom/turi/languagelearning/data/local/dao/UserDao;", "app_debug"})
@androidx.room.Database(entities = {com.turi.languagelearning.data.local.entity.UserEntity.class}, version = 1, exportSchema = false)
public abstract class TuriDatabase extends androidx.room.RoomDatabase {
    
    public TuriDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.turi.languagelearning.data.local.dao.UserDao userDao();
}