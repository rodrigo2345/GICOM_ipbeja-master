package com.example.gicom_ipbeja.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.cursos.activity_Agronomia;

public class ActivityShare extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
    }


    public void Home(View view) {
        Intent intent = (new Intent(ActivityShare.this, MainActivity.class));
        startActivity(intent);
    }

    public void Search(View view) {
        Intent intent = (new Intent(ActivityShare.this, PesquisaActivity.class));
        startActivity(intent);
    }


    public void Message(View view) {
        Intent intent = (new Intent(ActivityShare.this, apoioActivity.class));
        startActivity(intent);
    }
}