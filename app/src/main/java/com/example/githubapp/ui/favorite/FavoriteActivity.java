package com.example.githubapp.ui.favorite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.githubapp.R;
import com.example.githubapp.ui.adapter.UserListAdapter;
import com.example.githubapp.viewmodel.ViewModelFactory;

import java.util.Objects;

public class FavoriteActivity extends AppCompatActivity {

    private FavoriteViewModel viewModel;

    private RecyclerView rvUserList;
    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Favorite");

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(FavoriteViewModel.class);

        rvUserList = findViewById(R.id.rv_user_list);
        adapter = new UserListAdapter();

        viewModel.getFavorites().observe(this, userGithubs -> {
            adapter.setData(userGithubs);
        });

        rvUserList.setLayoutManager(new LinearLayoutManager(this));
        rvUserList.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}