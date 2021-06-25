package com.example.githubapp.ui.main;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.githubapp.R;
import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.data.model.UserReposGithub;
import com.example.githubapp.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProfileFragment extends Fragment {

    private MainViewModel viewModel;

    private UserGithub userGithub;
    private List<UserReposGithub> userReposGithubList;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory factory = ViewModelFactory.getInstance(getContext());
        viewModel = new ViewModelProvider(requireActivity(), factory).get(MainViewModel.class);

        viewModel.getDetailUser().observe(getViewLifecycleOwner(), userGithub -> {
            this.userGithub = userGithub;
        });

        viewModel.getReposUser().observe(getViewLifecycleOwner(), userReposGithubs -> {
            userReposGithubList = userReposGithubs;
        });
    }
}