package com.example.githubapp.data.local.room;

import android.content.Context;

import com.example.githubapp.data.local.entity.FavoriteEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteEntity.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract AppDao appDao();

    private static volatile AppDatabase instance;

    public static AppDatabase getInstance(Context context) {
        if (instance == null)
            instance = Room.databaseBuilder(
                    context.getApplicationContext(),
                    AppDatabase.class,
                    "favorite_db")
                    .allowMainThreadQueries()
                    .build();
        return instance;
    }
}
