package com.example.githubapp.data;

import com.example.githubapp.data.local.LocalDataSource;
import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.data.model.UserReposGithub;
import com.example.githubapp.data.preference.SessionManager;
import com.example.githubapp.data.remote.RemoteDataSource;
import com.example.githubapp.utils.AppExecutors;
import com.example.githubapp.utils.DataMapper;
import com.example.githubapp.utils.Helper;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;

public class AppRepository implements AppDataSource {
    private final SessionManager sessionManager;
    private final LocalDataSource localDataSource;
    private final RemoteDataSource remoteDataSource;
    private final AppExecutors appExecutors;

    /*
    ------------------------------------------------------------
    Remote Data Function
    */
    @Override
    public LiveData<List<UserGithub>> getUsers() {
        return Transformations.map(
                remoteDataSource.getUsers(),
                DataMapper::mapListUserResponseToUserGithub
        );
    }

    @Override
    public LiveData<UserGithub> getDetailUser(String username) {
        return Transformations.map(
                remoteDataSource.getDetailUser(username),
                DataMapper::mapUserResponseToUserGithub
        );
    }

    @Override
    public LiveData<List<UserReposGithub>> getReposUser(String username) {
        return Transformations.map(
                remoteDataSource.getReposUser(username),
                DataMapper::mapListReposResponseToUserReposGithub
        );
    }

    @Override
    public LiveData<List<UserGithub>> getSearchUser(String username) {
        return Transformations.map(
                remoteDataSource.getSearchUser(username),
                DataMapper::mapListUserResponseToUserGithub
        );
    }
    /*
    Remote Data Function
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    Local Data Function
    */
    @Override
    public LiveData<List<UserGithub>> getFavorites(String account) {
        return Transformations.map(
                localDataSource.getFavorites(account),
                DataMapper::mapListFavoriteEntityToUserGithub
        );
    }

    @Override
    public Boolean checkFavorite(String username, String account) {
        return localDataSource.checkFavorite(username, account);
    }

    @Override
    public void insertFavorite(UserGithub userGithub) {
        appExecutors.diskIO().execute(() -> localDataSource.insertFavorite(
                DataMapper.mapUserGithubToFavoriteEntity(userGithub)));
    }

    @Override
    public void deleteFavorite(UserGithub userGithub) {
        appExecutors.diskIO().execute(() -> localDataSource.deleteFavorite(
                DataMapper.mapUserGithubToFavoriteEntity(userGithub)));
    }
    /*
    Local Data Function
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    Session Manager Function
    */
    @Override
    public int login(String username, String password) {
        boolean verification = Helper.loginVerification(username, password);
        if (verification) {
            sessionManager.createLoginSession();
            sessionManager.saveToPreference(SessionManager.KEY_USERNAME, username);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String getSessionUsername() {
        return sessionManager.getFromPreference(SessionManager.KEY_USERNAME);
    }

    @Override
    public boolean isLogin() {
        return sessionManager.isLogin();
    }

    @Override
    public void logout() {
        sessionManager.logout();
    }
    /*
    Session Manager Function
    ------------------------------------------------------------
    */

    /*
    ------------------------------------------------------------
    Create Instance
    */
    private AppRepository(SessionManager sessionManager,
                          LocalDataSource localDataSource,
                          RemoteDataSource remoteDataSource,
                          AppExecutors appExecutors) {
        this.sessionManager = sessionManager;
        this.localDataSource = localDataSource;
        this.remoteDataSource = remoteDataSource;
        this.appExecutors = appExecutors;
    }

    private static volatile AppRepository instance;

    public static AppRepository getInstance(SessionManager sessionManager,
                                            LocalDataSource localDataSource,
                                            RemoteDataSource remoteDataSource,
                                            AppExecutors appExecutors) {
        if (instance == null)
            instance = new AppRepository(
                    sessionManager,
                    localDataSource,
                    remoteDataSource,
                    appExecutors
            );
        return instance;
    }
    /*
    Create Instance
    ------------------------------------------------------------
    */
}
