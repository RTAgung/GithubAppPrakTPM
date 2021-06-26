package com.example.githubapp.ui.detail;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.githubapp.R;
import com.example.githubapp.data.model.UserGithub;
import com.example.githubapp.data.model.UserReposGithub;
import com.example.githubapp.ui.adapter.RepoListAdapter;
import com.example.githubapp.viewmodel.ViewModelFactory;

import java.util.List;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_DATA_PARCEL = "extra_data_parcel";

    private DetailViewModel viewModel;

    private TextView detailName, detailUsername, detailEmail;
    private TextView detailDate, detailState, detailBio, followers, following, repos;
    private ImageView detailAvatar;
    private Button btnBrowser;
    private RecyclerView rvRepoList;

    private RepoListAdapter adapter;

    private Menu menu;

    private boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail");

        rvRepoList = findViewById(R.id.rv_repo_list);
        btnBrowser = findViewById(R.id.det_browser);
        detailAvatar = findViewById(R.id.detail_avatar);
        repos = findViewById(R.id.drepos_number);
        following = findViewById(R.id.dfollowing_number);
        followers = findViewById(R.id.dfollowers_number);
        detailBio = findViewById(R.id.detail_bio);
        detailState = findViewById(R.id.detail_state);
        detailDate = findViewById(R.id.detail_date);
        detailEmail = findViewById(R.id.detail_email);
        detailUsername = findViewById(R.id.detail_username);
        detailName = findViewById(R.id.detail_name);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        UserGithub intentData = getIntent().getParcelableExtra(EXTRA_DATA_PARCEL);
        viewModel.setInitData(intentData);

        adapter = new RepoListAdapter();
        rvRepoList.setLayoutManager(new LinearLayoutManager(this));
        rvRepoList.setAdapter(adapter);

        viewModel.getDetailUser().observe(this, this::populateProfile);

        viewModel.getReposUser().observe(this, this::populateRepo);

        viewModel.checkFavorite().observe(this, favorite -> {
            if (favorite != null) {
                isFavorite = favorite == 1;
                new Handler().postDelayed(this::changeFavoriteView, 250);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_detail, menu);
        if (menu != null) this.menu = menu;
        changeFavoriteView();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            case R.id.menu_favorite:
                clickFavorite();
        }
        return super.onOptionsItemSelected(item);
    }

    private void clickFavorite() {
        if (!isFavorite)
            viewModel.insertFavorite();
        else
            viewModel.deleteFavorite();
    }

    private void populateRepo(List<UserReposGithub> repos) {
        adapter.setData(repos);
    }

    private void populateProfile(UserGithub github) {
        detailName.setText(github.getName());
        detailUsername.setText(github.getUsername());
        detailEmail.setText(github.getEmail());
        detailDate.setText(github.getCreateAt());
        detailState.setText(github.getLocation());
        detailBio.setText(github.getBio());
        followers.setText(github.getFollowers() + "");
        following.setText(github.getFollowing() + "");
        repos.setText(github.getRepos() + "");

        Glide.with(this)
                .load(github.getAvatar())
                .centerCrop()
                .into(detailAvatar);

        btnBrowser.setOnClickListener(view -> {
            String url = github.getLink();
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });
    }

    private void changeFavoriteView() {
        if (isFavorite)
            menu.findItem(R.id.menu_favorite).setIcon(
                    ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_24)
            );
        else
            menu.findItem(R.id.menu_favorite).setIcon(
                    ContextCompat.getDrawable(this, R.drawable.ic_baseline_favorite_border_24)
            );
    }
}