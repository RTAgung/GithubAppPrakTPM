package com.example.githubapp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

public class UserGithub implements Parcelable {
    private int id;
    private String username;
    private String avatar;
    private String account;

    public UserGithub() {

    }

    public UserGithub(int id, String username, String avatar, String account) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.account = account;
    }

    protected UserGithub(Parcel in) {
        id = in.readInt();
        username = in.readString();
        avatar = in.readString();
        account = in.readString();
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

    public int getId() {
        return id;
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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(username);
        parcel.writeString(avatar);
        parcel.writeString(account);
    }
}
