package com.example.githubapp.ui.detail;

import com.example.githubapp.data.AppRepository;
import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.data.model.UserReposGithub;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    private final AppRepository appRepository;

    private String account;
    private String username;
    private String avatar;

    public void setInitData(UserGithub data) {
        username = data.getUsername();
        avatar = data.getAvatar();
    }

    public String getSessionUsername() {
        if (account == null) {
            account = appRepository.getSessionUsername();
        }
        return account;
    }

    public String getUsername() {
        return username;
    }

    public LiveData<Integer> checkFavorite() {
        return appRepository.checkFavorite(getUsername(), getSessionUsername());
    }

    public void insertFavorite() {
        appRepository.insertFavorite(new UserGithub(username, avatar, account));
    }

    public void deleteFavorite() {
        appRepository.deleteFavorite(new UserGithub(username, avatar, account));
    }

    public LiveData<List<UserReposGithub>> getReposUser() {
        return appRepository.getReposUser(getUsername());
    }

    public LiveData<UserGithub> getDetailUser() {
        return appRepository.getDetailUser(getUsername());
    }

    public DetailViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
}
