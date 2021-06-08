package com.example.githubapp.data.remote;

import com.example.githubapp.data.remote.service.ApiConfig;
import com.example.githubapp.data.remote.service.ApiService;

public class RemoteDataSource {
    private ApiConfig apiConfig;

    public RemoteDataSource(ApiConfig apiConfig) {
        this.apiConfig = apiConfig;
    }

    private static volatile RemoteDataSource instance;

    public static RemoteDataSource getInstance(ApiConfig apiConfig) {
        if (instance == null)
            instance = new RemoteDataSource(apiConfig);
        return instance;
    }
}
