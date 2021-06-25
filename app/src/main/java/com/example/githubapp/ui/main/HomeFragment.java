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
import com.example.githubapp.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

import java.util.List;


public class HomeFragment extends Fragment {

    private MainViewModel viewModel;
    private List<UserGithub> userGithubList;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ViewModelFactory factory = ViewModelFactory.getInstance(getContext());
        viewModel = new ViewModelProvider(requireActivity(), factory).get(MainViewModel.class);

        observeAll();
    }

    private void observeAll() {
        viewModel.getUsers().observe(getViewLifecycleOwner(), userGithubs -> {
            userGithubList = userGithubs;
        });
    }

    private void observeSearch(String query) {
        viewModel.getSearchUser(query).observe(getViewLifecycleOwner(), userGithubs -> {
            userGithubList = userGithubs;
        });
    }
}