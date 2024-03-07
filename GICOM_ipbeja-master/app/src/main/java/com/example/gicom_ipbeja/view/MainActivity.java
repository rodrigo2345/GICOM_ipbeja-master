package com.example.gicom_ipbeja.view;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ImageButton;
import android.widget.Toast;
import com.example.gicom_ipbeja.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton logoutButton = findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutConfirmationDialog();
            }
        });
        WebView webView = findViewById(R.id.webView);
        String video = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/del86G-Jxog?si=GF6pFHxKD2bokpKW\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        webView.loadData(video, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
    }

    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Confirmar Logout");
        builder.setMessage("Tem certeza que deseja sair?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                performLogout();
            }
        });
        builder.setNegativeButton("Cancelar", null);
        builder.show();
    }

    private void performLogout() {
        SharedPreferences preferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        String username = preferences.getString("username", "");

        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        if (!username.isEmpty()) {
            String logoutMessage = "Volte em breve, " + username + " \uD83D\uDE22";
            Toast.makeText(MainActivity.this, logoutMessage, Toast.LENGTH_SHORT).show();
        }

        Intent intent = new Intent(MainActivity.this, loginActivity.class);
        startActivity(intent);
        finish();
    }

    public void Search(View view) {
        Intent intent = new Intent(MainActivity.this, PesquisaActivity.class);
        startActivity(intent);
    }

    public void Message(View view) {
        Intent intent = new Intent(MainActivity.this, apoioActivity.class);
        startActivity(intent);
    }

    public void Share(View view) {
        Intent intent = new Intent(MainActivity.this, ActivityShare.class);
        startActivity(intent);
    }

    public void Sobre(View view) {
        Intent intent = new Intent(MainActivity.this, SobreActivity.class);
        startActivity(intent);
    }
}