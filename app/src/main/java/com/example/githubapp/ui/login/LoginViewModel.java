package com.example.githubapp.ui.login;

import com.example.githubapp.data.AppRepository;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private final AppRepository appRepository;

    public int login(String username, String password) {
        return appRepository.login(username, password);
    }

    public boolean isLogin() {
        return appRepository.isLogin();
    }

    public LoginViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
}
