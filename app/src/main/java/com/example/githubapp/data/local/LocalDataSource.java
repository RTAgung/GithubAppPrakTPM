package com.example.githubapp.data.local;

import com.example.githubapp.data.local.entity.FavoriteEntity;
import com.example.githubapp.data.local.room.AppDao;

import java.util.List;

import androidx.lifecycle.LiveData;

public class LocalDataSource {
    private AppDao appDao;

    public LiveData<List<FavoriteEntity>> getFavorites(String account) {
        return appDao.getFavorites(account);
    }

    public LiveData<Integer> checkFavorite(String username, String account) {
        return appDao.checkFavorite(username, account);
    }

    public void insertFavorite(FavoriteEntity favoriteEntity) {
        appDao.insertFavorite(favoriteEntity);
    }

    public void deleteFavorite(FavoriteEntity favoriteEntity) {
        appDao.deleteFavorite(favoriteEntity);
    }

    private LocalDataSource(AppDao appDao) {
        this.appDao = appDao;
    }

    private static LocalDataSource instance;

    public static LocalDataSource getInstance(AppDao appDao) {
        if (instance == null)
            instance = new LocalDataSource(appDao);
        return instance;
    }
}
