package com.example.githubapp.ui.main;

import com.example.githubapp.data.AppRepository;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private AppRepository appRepository;

    public MainViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
}
