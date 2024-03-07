package com.example.gicom_ipbeja.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.Cliente;
import com.example.gicom_ipbeja.viewmodel.RegisterViewModel;

public class registerActivity extends AppCompatActivity {

    private EditText edtNome;
    private EditText edtEmail;
    private EditText edtDistrito;
    private EditText edtEscola;
    private EditText edtUsername;
    private EditText edtPassword;
    private Button registerButton;
    private RegisterViewModel registerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerViewModel = new ViewModelProvider(this).get(RegisterViewModel.class);

        edtNome = findViewById(R.id.et_nome);
        edtEmail = findViewById(R.id.et_email);
        edtDistrito = findViewById(R.id.et_distrito);
        edtEscola = findViewById(R.id.et_escola);
        edtUsername = findViewById(R.id.et_username);
        edtPassword = findViewById(R.id.et_password);
        registerButton = findViewById(R.id.btn_registrar);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (camposEstaoPreenchidos()) {
                    String nome = edtNome.getText().toString().trim();
                    String email = edtEmail.getText().toString().trim();
                    String distrito = edtDistrito.getText().toString().trim();
                    String escola = edtEscola.getText().toString().trim();
                    String username = edtUsername.getText().toString().trim();
                    String password = edtPassword.getText().toString().trim();

                    registerViewModel.registerCliente(nome, username, password, email, distrito, escola);
                } else {
                    Toast.makeText(registerActivity.this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerViewModel.getRegistrationMessage().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String message) {
                Toast.makeText(registerActivity.this, message, Toast.LENGTH_SHORT).show();
                if (message.equals("Cliente registrado com sucesso!")) {
                    Intent intent = new Intent(registerActivity.this, loginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private boolean camposEstaoPreenchidos() {
        return !TextUtils.isEmpty(edtNome.getText().toString()) &&
                !TextUtils.isEmpty(edtEmail.getText().toString()) &&
                !TextUtils.isEmpty(edtDistrito.getText().toString()) &&
                !TextUtils.isEmpty(edtEscola.getText().toString()) &&
                !TextUtils.isEmpty(edtUsername.getText().toString()) &&
                !TextUtils.isEmpty(edtPassword.getText().toString());
    }

    public void LoginHere(View view) {
        Intent intent = new Intent(registerActivity.this, loginActivity.class);
        startActivity(intent);
    }
}
