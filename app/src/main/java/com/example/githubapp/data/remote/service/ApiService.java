package com.example.githubapp.data.remote.service;

import com.example.githubapp.data.remote.response.ReposResponse;
import com.example.githubapp.data.remote.response.SearchResponse;
import com.example.githubapp.data.remote.response.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("users?")
    Call<List<UserResponse>> getUsers(@Query("since") int random);

    @GET("users/{username}")
    Call<UserResponse> getDetailUser(@Path("username") String username);

    @GET("users/{username}/repos")
    Call<List<ReposResponse>> getReposUser(@Path("username") String username);

    @GET("search/users?")
    Call<SearchResponse> getSearchUser(@Query("q") String username);
}
