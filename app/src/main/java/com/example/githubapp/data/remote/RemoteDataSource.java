package com.example.githubapp.data.remote;

import android.util.Log;

import com.example.githubapp.data.remote.response.ReposResponse;
import com.example.githubapp.data.remote.response.SearchResponse;
import com.example.githubapp.data.remote.response.UserResponse;
import com.example.githubapp.data.remote.service.ApiConfig;

import java.util.List;
import java.util.Random;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RemoteDataSource {
    private final ApiConfig apiConfig;

    public LiveData<List<UserResponse>> getUsers() {
        MutableLiveData<List<UserResponse>> users = new MutableLiveData<>();
        int random = new Random().nextInt(1000000) + 1;
        apiConfig.getApiService().getUsers(random).enqueue(new Callback<List<UserResponse>>() {
            @Override
            public void onResponse(Call<List<UserResponse>> call, Response<List<UserResponse>> response) {
                List<UserResponse> data = response.body();
                if (data != null)
                    users.postValue(data);
            }

            @Override
            public void onFailure(Call<List<UserResponse>> call, Throwable t) {
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

    public LiveData<List<ReposResponse>> getReposUser(String username) {
        MutableLiveData<List<ReposResponse>> repos = new MutableLiveData<>();
        apiConfig.getApiService().getReposUser(username).enqueue(new Callback<List<ReposResponse>>() {
            @Override
            public void onResponse(Call<List<ReposResponse>> call, Response<List<ReposResponse>> response) {
                List<ReposResponse> data = response.body();
                if (data != null)
                    repos.postValue(data);
            }

            @Override
            public void onFailure(Call<List<ReposResponse>> call, Throwable t) {
                Log.e("API getReposUser()", t.getMessage());
            }
        });
        return repos;
    }

    public LiveData<List<UserResponse>> getSearchUser(String username) {
        MutableLiveData<List<UserResponse>> users = new MutableLiveData<>();
        apiConfig.getApiService().getSearchUser(username).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                SearchResponse data = response.body();
                if (data != null) {
                    users.postValue(data.getItems());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {
                Log.e("API getSearchUser()", t.getMessage());
            }
        });
        return users;
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
