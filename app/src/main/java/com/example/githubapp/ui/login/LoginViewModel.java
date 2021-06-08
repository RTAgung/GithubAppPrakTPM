package com.example.githubapp.ui.login;

import com.example.githubapp.data.AppRepository;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel {
    private AppRepository appRepository;

    public LoginViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
}
