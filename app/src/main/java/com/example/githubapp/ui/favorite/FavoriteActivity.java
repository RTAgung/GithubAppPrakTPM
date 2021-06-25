package com.example.githubapp.ui.favorite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.githubapp.R;
import com.example.githubapp.viewmodel.ViewModelFactory;

import java.util.Objects;

public class FavoriteActivity extends AppCompatActivity {

    private FavoriteViewModel viewModel;

    private RecyclerView rvUserList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(FavoriteViewModel.class);

        rvUserList = findViewById(R.id.rv_user_list);

    }
}