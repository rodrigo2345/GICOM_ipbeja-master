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

public class activity_Audiovisual_Multimedia extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audiovisual_multimedia);
        List<Localizacao> localizacaoList = new ArrayList<>();
        localizacaoList.add(new Localizacao("Audiovisual e Multimedia", "data:image/png;base64,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",
                "Instituto Politécnico de Beja (IPBeja)", "https://www.ipbeja.pt/cursos/ese-am/Paginas/default.aspx", "284 315 000"));



        LocalizacaoAdapter localizacaoAdapter = new LocalizacaoAdapter(localizacaoList);

        RecyclerView recyclerViewLocalizacao = findViewById(R.id.recyclerview_localização14);


        recyclerViewLocalizacao.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewLocalizacao.setAdapter(localizacaoAdapter);


        List<Detalhes> detalhesList = new ArrayList<>();
        detalhesList.add(new Detalhes("Audiovisual e Multimedia","data:image/jpeg;base64,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","O Curso de Audiovisual e Multimédia é \num Curso da Escola Superior de Educação","Teve início no ano lectivo de 2018/2019","Os objetivos considerar a região envolvente como um território de ensino e aprendizagem onde os estudantes irão desenvolver aptidões técnicas e criativas."));
        RecyclerView recyclerViewDetalhes = findViewById(R.id.recyclerView_detalhes14);
        DetalhesAdapter detalhesAdapter = new DetalhesAdapter(detalhesList);
        recyclerViewDetalhes.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewDetalhes.setAdapter(detalhesAdapter);
    }

    public void Search(View view) {
        Intent intent = (new Intent(activity_Audiovisual_Multimedia.this, PesquisaActivity.class));
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = (new Intent(activity_Audiovisual_Multimedia.this, MainActivity.class));
        startActivity(intent);
    }

    public void Message(View view) {
        Intent intent = (new Intent(activity_Audiovisual_Multimedia.this, apoioActivity.class));
        startActivity(intent);
    }
    public void Share(View view) {
        Intent intent = (new Intent(activity_Audiovisual_Multimedia.this, ActivityShare.class));
        startActivity(intent);
    }
}
