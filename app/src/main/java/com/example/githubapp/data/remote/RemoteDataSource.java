package com.example.githubapp.data.remote;

import android.util.Log;

import com.example.githubapp.data.remote.response.ReposResponse;
import com.example.githubapp.data.remote.response.UserResponse;
import com.example.githubapp.data.remote.service.ApiConfig;
import com.example.githubapp.data.remote.service.ApiService;

import java.util.ArrayList;
import java.util.Random;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {
    private ApiConfig apiConfig;

    public LiveData<ArrayList<UserResponse>> getUsers() {
        MutableLiveData<ArrayList<UserResponse>> users = new MutableLiveData<>();
        int random = new Random().nextInt(1000000) + 1;
        apiConfig.getApiService().getUsers(random).enqueue(new Callback<ArrayList<UserResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<UserResponse>> call, Response<ArrayList<UserResponse>> response) {
                ArrayList<UserResponse> data = response.body();
                if (data != null)
                    users.postValue(data);
            }

            @Override
            public void onFailure(Call<ArrayList<UserResponse>> call, Throwable t) {
                Log.e("API getUsers()", t.getMessage());
            }
        });
        return users;
    }

    public LiveData<UserResponse> getDetailUser(String username) {
        MutableLiveData<UserResponse> user = new MutableLiveData<>();
        apiConfig.getApiService().getDetailUser(username).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse data = response.body();
                if (data != null)
                    user.postValue(data);
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("API getDetailUser()", t.getMessage());
            }
        });
        return user;
    }

    public LiveData<ArrayList<ReposResponse>> getReposUser(String username) {
        MutableLiveData<ArrayList<ReposResponse>> repos = new MutableLiveData<>();
        apiConfig.getApiService().getReposUser(username).enqueue(new Callback<ArrayList<ReposResponse>>() {
            @Override
            public void onResponse(Call<ArrayList<ReposResponse>> call, Response<ArrayList<ReposResponse>> response) {
                ArrayList<ReposResponse> data = response.body();
                if (data != null)
                    repos.postValue(data);
            }

            @Override
            public void onFailure(Call<ArrayList<ReposResponse>> call, Throwable t) {
                Log.e("API getReposUser()", t.getMessage());
            }
        });
        return repos;
    }

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
