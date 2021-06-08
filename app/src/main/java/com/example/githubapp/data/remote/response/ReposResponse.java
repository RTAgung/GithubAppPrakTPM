package com.example.githubapp.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class ReposResponse {
    @SerializedName("language")
    private String language;

    @SerializedName("name")
    private String name;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("owner")
    private UserResponse owner;

    public String getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public UserResponse getOwner() {
        return owner;
    }
}