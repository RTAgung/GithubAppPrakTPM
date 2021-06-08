package com.example.githubapp.data.local.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "favorite",
        indices = {@Index(value = {"username"},
                unique = true)})
public class FavoriteEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "username")
    private String username;

    @ColumnInfo(name = "avatar")
    private String avatar;

    @ColumnInfo(name = "account")
    private String account;

    public FavoriteEntity(String username, String avatar, String account) {
        this.username = username;
        this.avatar = avatar;
        this.account = account;
    }

    @Ignore
    public FavoriteEntity(int id, String username, String avatar, String account) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.account = account;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
