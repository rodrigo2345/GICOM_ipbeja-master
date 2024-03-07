package com.example.gicom_ipbeja.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.Cliente;
import com.example.gicom_ipbeja.viewmodel.LoginViewModel;

public class loginActivity extends AppCompatActivity {

    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        usernameEditText = findViewById(R.id.et_username);
        passwordEditText = findViewById(R.id.et_password);
        loginButton = findViewById(R.id.bt_mestra);

        final ProgressBar progressBar = findViewById(R.id.progressBar);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString().trim();
                String password = passwordEditText.getText().toString().trim();

                if (!username.isEmpty() && !password.isEmpty()) {
                    progressBar.setVisibility(View.VISIBLE);

                    loginViewModel.login(username, password);

                    loginViewModel.getClienteLiveData().observe(loginActivity.this, new Observer<Cliente>() {
                        @Override
                        public void onChanged(Cliente cliente) {
                            if (cliente != null) {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        progressBar.setVisibility(View.INVISIBLE);

                                        Toast.makeText(loginActivity.this, "Bem-vindo, " + cliente.getNome() + " \uD83D\uDE00", Toast.LENGTH_SHORT).show();

                                        SharedPreferences preferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
                                        SharedPreferences.Editor editor = preferences.edit();
                                        editor.putString("username", cliente.getNome());
                                        editor.apply();

                                        Intent intent = new Intent(loginActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }, 1500);
                            } else {
                                progressBar.setVisibility(View.INVISIBLE);
                                Toast.makeText(loginActivity.this, "Username ou Password incorretos", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                } else {
                    Toast.makeText(loginActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void RegisterHere(View view) {
        Intent intent = new Intent(loginActivity.this, registerActivity.class);
        startActivity(intent);
    }
}
