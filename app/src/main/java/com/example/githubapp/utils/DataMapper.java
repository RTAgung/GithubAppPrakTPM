package com.example.githubapp.utils;

import com.example.githubapp.data.local.entity.FavoriteEntity;
import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.data.model.UserReposGithub;
import com.example.githubapp.data.remote.response.ReposResponse;
import com.example.githubapp.data.remote.response.UserResponse;

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

    public static List<UserGithub> mapListUserResponseToUserGithub(List<UserResponse> userResponses) {
        ArrayList<UserGithub> listUserGithub = new ArrayList<>();
        for (int i = 0; i < userResponses.size(); i++) {
            UserGithub temp = mapUserResponseToUserGithub(userResponses.get(i));
            listUserGithub.add(temp);
        }
        return listUserGithub;
    }

    public static UserGithub mapUserResponseToUserGithub(UserResponse userResponse) {
        return new UserGithub(
                userResponse.getName(),
                userResponse.getLogin(),
                userResponse.getAvatarUrl(),
                userResponse.getHtmlUrl(),
                userResponse.getEmail(),
                userResponse.getLocation(),
                userResponse.getBio(),
                userResponse.getCreatedAt(),
                userResponse.getFollowers(),
                userResponse.getFollowing(),
                userResponse.getPublicRepos()
        );
    }

    public static List<UserReposGithub> mapListReposResponseToUserReposGithub(List<ReposResponse> reposResponses) {
        ArrayList<UserReposGithub> listUserReposGithub = new ArrayList<>();
        for (int i = 0; i < reposResponses.size(); i++) {
            UserReposGithub temp = mapReposResponseToUserReposGithub(reposResponses.get(i));
            listUserReposGithub.add(temp);
        }
        return listUserReposGithub;
    }

    public static UserReposGithub mapReposResponseToUserReposGithub(ReposResponse reposResponse) {
        return new UserReposGithub(
                reposResponse.getName(),
                reposResponse.getLanguage(),
                reposResponse.getUpdatedAt()
        );
    }
}
