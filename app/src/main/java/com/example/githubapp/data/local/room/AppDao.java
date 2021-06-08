package com.example.githubapp.data.local.room;

import com.example.githubapp.data.local.entity.FavoriteEntity;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface AppDao {
    @Query("SELECT * FROM favorite WHERE account = :account")
    LiveData<List<FavoriteEntity>> getFavorites(String account);

    @Query("SELECT 1 FROM favorite WHERE username = :username AND account = :account")
    LiveData<Integer> checkFavorite(String username, String account);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertFavorite(FavoriteEntity favoriteEntity);

    @Delete
    void deleteFavorite(FavoriteEntity favoriteEntity);
}
