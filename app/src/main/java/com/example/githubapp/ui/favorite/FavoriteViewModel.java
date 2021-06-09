package com.example.githubapp.ui.favorite;

import com.example.githubapp.data.AppRepository;
import com.example.githubapp.data.model.UserGithub;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class FavoriteViewModel extends ViewModel {
    private AppRepository appRepository;

    private String account;

    public String getSessionUsername() {
        if (account == null) {
            account = appRepository.getSessionUsername();
        }
        return account;
    }

    public LiveData<List<UserGithub>> getFavorites() {
        return appRepository.getFavorites(getSessionUsername());
    }

    public FavoriteViewModel(AppRepository appRepository) {
        this.appRepository = appRepository;
    }
}
