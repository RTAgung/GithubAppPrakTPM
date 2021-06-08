package com.example.githubapp.data;

import com.example.githubapp.data.model.UserGithub;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface AppDataSource {

    /*
    ------------------------------------------------------------
    Local Data Function
    */
    LiveData<List<UserGithub>> getFavorites(String account);

    LiveData<Integer> checkFavorite(String username, String account);

    void insertFavorite(UserGithub userGithub);

    void deleteFavorite(UserGithub userGithub);
    /*
    Local Data Function
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    Session Manager Function
    */
    int login(String username, String password);

    String getSessionUsername();

    boolean isLogin();

    void logout();
    /*
    Session Manager Function
    ------------------------------------------------------------
    */
}
