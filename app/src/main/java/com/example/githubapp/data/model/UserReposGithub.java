package com.example.githubapp.data.model;

public class UserReposGithub {
    private String name = "";
    private String language = "";
    private String update = "";

    public UserReposGithub(String name, String language, String update) {
        this.name = name;
        this.language = language;
        this.update = update;
    }

    public String getName() {
        return name;
    }

    public String getLanguage() {
        return language;
    }

    public String getUpdate() {
        return update;
    }
}
