package com.example.githubapp.ui.detail;

import com.example.githubapp.data.AppRepository;

import androidx.lifecycle.ViewModel;

public class DetailViewModel extends ViewModel {
    private AppRepository appRepository;

    public DetailViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
}
