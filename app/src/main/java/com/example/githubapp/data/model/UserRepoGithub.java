package com.example.githubapp.data.model;

public class UserRepoGithub {
    private String name = "";
    private String language = "";
    private String update = "";

    public UserRepoGithub(String name, String language, String update) {
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
