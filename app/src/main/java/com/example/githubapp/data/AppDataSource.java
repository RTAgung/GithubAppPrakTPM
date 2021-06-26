package com.example.githubapp.data;

import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.data.model.UserReposGithub;

import java.util.List;

import androidx.lifecycle.LiveData;

public interface AppDataSource {

    /*
    ------------------------------------------------------------
    Remote Data Function
    */
    LiveData<List<UserGithub>> getUsers();

    LiveData<UserGithub> getDetailUser(String username);

    LiveData<List<UserReposGithub>> getReposUser(String username);

    LiveData<List<UserGithub>> getSearchUser(String username);
    /*
    Remote Data Function
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    Local Data Function
    */
    LiveData<List<UserGithub>> getFavorites(String account);

    Boolean checkFavorite(String username, String account);

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
