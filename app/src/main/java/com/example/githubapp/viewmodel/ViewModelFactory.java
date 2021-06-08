package com.example.githubapp.viewmodel;

import android.content.Context;

import com.example.githubapp.data.AppRepository;
import com.example.githubapp.di.Injection;
import com.example.githubapp.ui.detail.DetailViewModel;
import com.example.githubapp.ui.login.LoginViewModel;
import com.example.githubapp.ui.main.MainViewModel;

import org.jetbrains.annotations.NotNull;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private AppRepository appRepository;

    @SuppressWarnings("unchecked")
    @NotNull
    @Override
    public <T extends ViewModel> T create(@NonNull @NotNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class))
            return (T) new LoginViewModel(appRepository);
        else if (modelClass.isAssignableFrom(MainViewModel.class))
            return (T) new MainViewModel(appRepository);
        else if (modelClass.isAssignableFrom(DetailViewModel.class))
            return (T) new DetailViewModel(appRepository);

        throw new IllegalArgumentException("Unknown ViewModel class: " + modelClass.getName());
    }

    private ViewModelFactory(AppRepository appRepository) {
        this.appRepository = appRepository;
    }

    private static volatile ViewModelFactory instance;

    public static ViewModelFactory getInstance(Context context) {
        if (instance == null)
            instance = new ViewModelFactory(Injection.provideRepository(context));
        return instance;
    }
}