package com.example.gicom_ipbeja.cursos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.Detalhes;
import com.example.gicom_ipbeja.data.localdatabase.Localizacao;
import com.example.gicom_ipbeja.view.ActivityShare;
import com.example.gicom_ipbeja.view.DetalhesAdapter;
import com.example.gicom_ipbeja.view.LocalizacaoAdapter;
import com.example.gicom_ipbeja.view.MainActivity;
import com.example.gicom_ipbeja.view.PesquisaActivity;
import com.example.gicom_ipbeja.view.apoioActivity;

import java.util.ArrayList;
import java.util.List;

public class activity_Psicogerontologia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_psicogerontologia);
        List<Localizacao> localizacaoList = new ArrayList<>();
        localizacaoList.add(new Localizacao("Psicogerontologia", "data:image/png;base64,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",
                "Instituto Politécnico de Beja (IPBeja)", "https://www.ipbeja.pt/cursos/cstp/ese-cstp-psicog/Paginas/default.aspx", "284 315 000"));

        LocalizacaoAdapter localizacaoAdapter = new LocalizacaoAdapter(localizacaoList);

        RecyclerView recyclerViewLocalizacao = findViewById(R.id.recyclerview_localização20);


        recyclerViewLocalizacao.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewLocalizacao.setAdapter(localizacaoAdapter);


        List<Detalhes> detalhesList = new ArrayList<>();
        detalhesList.add(new Detalhes("Psicogerontologia","data:image/jpeg;base64,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","O Curso Técnico Superior Profissional (CTeSP) de Psicogerontologia é um Curso da Escola Superior de Educação","Teve início no ano lectivo de 2016/2017","Os objetivos o desenvolvimento de competências psicossociais."));
        RecyclerView recyclerViewDetalhes = findViewById(R.id.recyclerView_detalhes20);
        DetalhesAdapter detalhesAdapter = new DetalhesAdapter(detalhesList);
        recyclerViewDetalhes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewDetalhes.setAdapter(detalhesAdapter);
    }

    public void Search(View view) {
        Intent intent = (new Intent(activity_Psicogerontologia.this, PesquisaActivity.class));
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = (new Intent(activity_Psicogerontologia.this, MainActivity.class));
        startActivity(intent);
    }

    public void Message(View view) {
        Intent intent = (new Intent(activity_Psicogerontologia.this, apoioActivity.class));
        startActivity(intent);
    }
    public void Share(View view) {
        Intent intent = (new Intent(activity_Psicogerontologia.this, ActivityShare.class));
        startActivity(intent);
    }
}