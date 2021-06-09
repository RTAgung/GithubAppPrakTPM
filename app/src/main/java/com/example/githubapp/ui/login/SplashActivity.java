package com.example.githubapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.githubapp.R;
import com.example.githubapp.ui.main.MainActivity;
import com.example.githubapp.viewmodel.ViewModelFactory;

public class SplashActivity extends AppCompatActivity {

    private LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(LoginViewModel.class);

        new Handler().postDelayed(() -> {
            Intent intent = viewModel.isLogin() ?
                    new Intent(this, MainActivity.class) :
                    new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        }, 4000);
    }
}