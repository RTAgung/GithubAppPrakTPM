package com.example.githubapp.data.remote.response;

import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("bio")
    private String bio;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("login")
    private String login;

    @SerializedName("public_repos")
    private int publicRepos;

    @SerializedName("email")
    private String email;

    @SerializedName("followers")
    private int followers;

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("html_url")
    private String htmlUrl;

    @SerializedName("following")
    private int following;

    @SerializedName("name")
    private String name;

    @SerializedName("location")
    private String location;

    public String getBio() {
        return bio;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getLogin() {
        return login;
    }

    public int getPublicRepos() {
        return publicRepos;
    }

    public String getEmail() {
        return email;
    }

    public int getFollowers() {
        return followers;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public String getHtmlUrl() {
        return htmlUrl;
    }

    public int getFollowing() {
        return following;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

}