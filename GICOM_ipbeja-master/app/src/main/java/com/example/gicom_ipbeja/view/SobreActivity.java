package com.example.gicom_ipbeja.view;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.gicom_ipbeja.About.CTeSP;
import com.example.gicom_ipbeja.About.Licenciatura;
import com.example.gicom_ipbeja.About.Mestrado;
import com.example.gicom_ipbeja.R;

public class SobreActivity extends AppCompatActivity {

    CardView cardViewctesp, cardViewlicen, cardViewmestra, cardViewinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        cardViewctesp = findViewById(R.id.cardViewctesp);
        cardViewlicen = findViewById(R.id.cardViewlicen);
        cardViewmestra = findViewById(R.id.cardViewctestpa);
        cardViewinfo = findViewById(R.id.cardViewinfo);

        cardViewctesp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ctesp();
            }
        });

        cardViewlicen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                licenciatura();
            }
        });

        cardViewmestra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mestrado();
            }
        });


        cardViewinfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info();
            }
        });
    }


    private void ctesp(){
        Intent intent = new Intent(this, CTeSP.class);
        startActivity(intent);
    }

    private void licenciatura(){
        Intent intent = new Intent(this, Licenciatura.class);
        startActivity(intent);
    }

    private void mestrado(){
        Intent intent = new Intent(this, Mestrado.class);
        startActivity(intent);
    }

    private void info(){
        Uri uri = Uri.parse("https://www.ipbeja.pt/cursos/AcessoEnsinoSuperior");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }






    public void Search(View view) {
        Intent intent = (new Intent(SobreActivity.this, PesquisaActivity.class));
        startActivity(intent);
    }

    public void Share(View view) {
        Intent intent = (new Intent(SobreActivity.this, ActivityShare.class));
        startActivity(intent);
    }


    public void Message(View view) {
        Intent intent = (new Intent(SobreActivity.this, apoioActivity.class));
        startActivity(intent);
    }


    public void Home(View view) {
        Intent intent = (new Intent(SobreActivity.this, MainActivity.class));
        startActivity(intent);
    }
}

