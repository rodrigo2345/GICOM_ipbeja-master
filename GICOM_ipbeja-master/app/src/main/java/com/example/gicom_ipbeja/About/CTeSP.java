package com.example.gicom_ipbeja.About;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.view.MainActivity;
import com.example.gicom_ipbeja.view.PesquisaActivity;
import com.example.gicom_ipbeja.view.apoioActivity;
import com.example.gicom_ipbeja.view.loginActivity;

import java.util.ArrayList;
import java.util.List;

public class CTeSP extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ctesp);
    }
    public void Search(View view) {
        Intent intent = (new Intent(CTeSP.this, PesquisaActivity.class));
        startActivity(intent);
    }

    public void Message(View view) {
        Intent intent = (new Intent(CTeSP.this, apoioActivity.class));
        startActivity(intent);
    }


    public void Home(View view) {
        Intent intent = (new Intent(CTeSP.this, MainActivity.class));
        startActivity(intent);
    }
}

