package com.example.githubapp.ui.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.githubapp.R;
import com.example.githubapp.ui.main.MainActivity;
import com.example.githubapp.viewmodel.ViewModelFactory;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private LoginViewModel viewModel;

    private TextInputEditText etUsername, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().setTitle("Login");

        ViewModelFactory factory = ViewModelFactory.getInstance(this);
        viewModel = new ViewModelProvider(this, factory).get(LoginViewModel.class);

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(view -> {
            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            if (username.isEmpty()) etUsername.setError("Cannot Empty");
            else if (password.isEmpty()) etPassword.setError("Cannot Empty");
            else {
                if (viewModel.login(username, password) == 1)
                    startActivity(new Intent(this, MainActivity.class));
                else
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
            }
        });
    }
}