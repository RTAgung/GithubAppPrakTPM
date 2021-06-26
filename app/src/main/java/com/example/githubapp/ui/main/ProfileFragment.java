package com.example.githubapp.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.githubapp.R;
import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.data.model.UserReposGithub;
import com.example.githubapp.ui.adapter.RepoListAdapter;
import com.example.githubapp.viewmodel.ViewModelFactory;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ProfileFragment extends Fragment {

    private MainViewModel viewModel;

    private TextView profileName, profileUsername, profileEmail;
    private TextView profileDate, profileState, profileBio, followers, following, repos;
    private ImageView profileAvatar;
    private Button btnBrowser;
    private RecyclerView rvRepoList;

    private RepoListAdapter adapter;

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

        rvRepoList = view.findViewById(R.id.rv_repo_list);
        btnBrowser = view.findViewById(R.id.btn_browser);
        profileAvatar = view.findViewById(R.id.profile_avatar);
        repos = view.findViewById(R.id.repos_number);
        following = view.findViewById(R.id.following_number);
        followers = view.findViewById(R.id.followers_number);
        profileBio = view.findViewById(R.id.profile_bio);
        profileState = view.findViewById(R.id.profile_state);
        profileDate = view.findViewById(R.id.profile_date);
        profileEmail = view.findViewById(R.id.profile_email);
        profileUsername = view.findViewById(R.id.profile_username);
        profileName = view.findViewById(R.id.profile_name);

        ViewModelFactory factory = ViewModelFactory.getInstance(getContext());
        viewModel = new ViewModelProvider(requireActivity(), factory).get(MainViewModel.class);

        adapter = new RepoListAdapter();
        rvRepoList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvRepoList.setAdapter(adapter);

        viewModel.getDetailUser().observe(getViewLifecycleOwner(), this::populateProfile);

        viewModel.getReposUser().observe(getViewLifecycleOwner(), this::populateRepo);
    }

    private void populateRepo(List<UserReposGithub> repos) {
        adapter.setData(repos);
    }

    private void populateProfile(UserGithub github) {
        profileName.setText(github.getName());
        profileUsername.setText(github.getUsername());
        profileEmail.setText(github.getEmail());
        profileDate.setText(github.getCreateAt());
        profileState.setText(github.getLocation());
        profileBio.setText(github.getBio());
        followers.setText(github.getFollowers() + "");
        following.setText(github.getFollowing() + "");
        repos.setText(github.getRepos() + "");

        Glide.with(getView().getContext())
                .load(github.getAvatar())
                .centerCrop()
                .into(profileAvatar);

        btnBrowser.setOnClickListener(view -> {
            String url = github.getLink();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        getActivity()
                .setTitle("Profile");
    }
}