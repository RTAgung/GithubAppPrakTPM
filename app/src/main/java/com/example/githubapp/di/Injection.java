package com.example.githubapp.di;

import android.content.Context;

import com.example.githubapp.data.AppRepository;
import com.example.githubapp.data.local.LocalDataSource;
import com.example.githubapp.data.local.room.AppDatabase;
import com.example.githubapp.data.preference.SessionManager;
import com.example.githubapp.data.remote.RemoteDataSource;
import com.example.githubapp.data.remote.service.ApiConfig;
import com.example.githubapp.utils.AppExecutors;

public class Injection {
    public static AppRepository provideRepository(Context context) {
        SessionManager sessionManager = SessionManager.getInstance(context);

        AppDatabase appDatabase = AppDatabase.getInstance(context);
        LocalDataSource localDataSource = LocalDataSource.getInstance(appDatabase.appDao());

        ApiConfig apiConfig = new ApiConfig();
        RemoteDataSource remoteDataSource = RemoteDataSource.getInstance(apiConfig);

        AppExecutors appExecutors = new AppExecutors();

        return AppRepository.getInstance(sessionManager, localDataSource, remoteDataSource, appExecutors);
    }
}
