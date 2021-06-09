package com.example.githubapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

public class UserGithub implements Parcelable {
    private int id;
    private String name = "";
    private String username = "";
    private String avatar = "";
    private String account = "";
    private String link = "";
    private String email = "";
    private String location = "";
    private String bio = "";
    private String createAt = "";
    private int followers;
    private int following;
    private int repos;
    private List<UserReposGithub> listRepos;

    public UserGithub(String username, String avatar, String account) {
        this.username = username;
        this.avatar = avatar;
        this.account = account;
    }

    public UserGithub(int id, String username, String avatar, String account) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.account = account;
    }

    public UserGithub(String name,
                      String username,
                      String avatar,
                      String link,
                      String email,
                      String location,
                      String bio,
                      String createAt,
                      int followers,
                      int following,
                      int repos) {
        this.name = name;
        this.username = username;
        this.avatar = avatar;
        this.link = link;
        this.email = email;
        this.location = location;
        this.bio = bio;
        this.createAt = createAt;
        this.followers = followers;
        this.following = following;
        this.repos = repos;
    }

    public UserGithub() {

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAccount() {
        return account;
    }

    public String getLink() {
        return link;
    }

    public String getEmail() {
        return email;
    }

    public String getLocation() {
        return location;
    }

    public String getBio() {
        return bio;
    }

    public String getCreateAt() {
        return createAt;
    }

    public int getFollowers() {
        return followers;
    }

    public int getFollowing() {
        return following;
    }

    public int getRepos() {
        return repos;
    }

    public List<UserReposGithub> getListRepos() {
        return listRepos;
    }

    public static Creator<UserGithub> getCREATOR() {
        return CREATOR;
    }

    protected UserGithub(Parcel in) {
        id = in.readInt();
        name = in.readString();
        username = in.readString();
        avatar = in.readString();
        account = in.readString();
        link = in.readString();
        email = in.readString();
        location = in.readString();
        bio = in.readString();
        createAt = in.readString();
        followers = in.readInt();
        following = in.readInt();
        repos = in.readInt();
    }

    public static final Creator<UserGithub> CREATOR = new Creator<UserGithub>() {
        @Override
        public UserGithub createFromParcel(Parcel in) {
            return new UserGithub(in);
        }

        @Override
        public UserGithub[] newArray(int size) {
            return new UserGithub[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(name);
        parcel.writeString(username);
        parcel.writeString(avatar);
        parcel.writeString(account);
        parcel.writeString(link);
        parcel.writeString(email);
        parcel.writeString(location);
        parcel.writeString(bio);
        parcel.writeString(createAt);
        parcel.writeInt(followers);
        parcel.writeInt(following);
        parcel.writeInt(repos);
    }
}
