package com.example.githubapp.ui.main;

import com.example.githubapp.data.AppRepository;
import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.data.model.UserReposGithub;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private final AppRepository appRepository;

    private String account;

    public String getSessionUsername() {
        if (account == null) {
            account = appRepository.getSessionUsername();
        }
        return account;
    }

    public LiveData<List<UserGithub>> getUsers() {
        return appRepository.getUsers();
    }

    public LiveData<UserGithub> getDetailUser() {
        return appRepository.getDetailUser(getSessionUsername());
    }

    public LiveData<List<UserReposGithub>> getReposUser() {
        return appRepository.getReposUser(getSessionUsername());
    }

    public LiveData<List<UserGithub>> getSearchUser(String username) {
        return appRepository.getSearchUser(username);
    }

    public void logout() {
        appRepository.logout();
    }

    public MainViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
}
