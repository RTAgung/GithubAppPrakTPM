package com.example.githubapp.ui.detail;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.githubapp.R;
import com.example.githubapp.viewmodel.ViewModelFactory;

public class DetailActivity extends AppCompatActivity {

    private DetailViewModel viewModel;

    private boolean isFavorite = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(DetailViewModel.class);

        viewModel.checkFavorite().observe(this, favorite -> {
            isFavorite = favorite > 0;
        });
    }
}