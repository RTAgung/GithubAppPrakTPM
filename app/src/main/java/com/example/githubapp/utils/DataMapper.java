package com.example.githubapp.utils;

import com.example.githubapp.data.local.entity.FavoriteEntity;
import com.example.githubapp.data.model.UserGithub;

import java.util.ArrayList;
import java.util.List;

public class DataMapper {
    public static List<UserGithub> mapListFavoriteEntityToUserGithub(List<FavoriteEntity> favoriteEntities) {
        ArrayList<UserGithub> listUserGithub = new ArrayList<>();
        for (int i = 0; i < favoriteEntities.size(); i++) {
            UserGithub temp = mapFavoriteEntityToUserGithub(favoriteEntities.get(i));
            listUserGithub.add(temp);
        }
        return listUserGithub;
    }

    public static UserGithub mapFavoriteEntityToUserGithub(FavoriteEntity favoriteEntity) {
        return new UserGithub(
                favoriteEntity.getId(),
                favoriteEntity.getUsername(),
                favoriteEntity.getAvatar(),
                favoriteEntity.getAccount()
        );
    }

    public static FavoriteEntity mapUserGithubToFavoriteEntity(UserGithub userGithub) {
        return new FavoriteEntity(
                userGithub.getId(),
                userGithub.getUsername(),
                userGithub.getAvatar(),
                userGithub.getAccount()
        );
    }
}
