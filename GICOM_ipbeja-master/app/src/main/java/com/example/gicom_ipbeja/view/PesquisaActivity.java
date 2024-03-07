package com.example.gicom_ipbeja.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.cursos.activity_Agronomia;
import com.example.gicom_ipbeja.cursos.activity_Agropecuaria_Mediterranica;
import com.example.gicom_ipbeja.cursos.activity_Analises_Laboratoriais;
import com.example.gicom_ipbeja.cursos.activity_Apoio_Cuidados_Continuados_Integrados;
import com.example.gicom_ipbeja.cursos.activity_Apoio_Infancia;
import com.example.gicom_ipbeja.cursos.activity_Audiovisual_Multimedia;
import com.example.gicom_ipbeja.cursos.activity_Ciência_Tecnologias_dos_Alimentos;
import com.example.gicom_ipbeja.cursos.activity_Comercio_Internacional;
import com.example.gicom_ipbeja.cursos.activity_Culturas_Regadas;
import com.example.gicom_ipbeja.cursos.activity_Desporto;
import com.example.gicom_ipbeja.cursos.activity_Desporto_Lazer_Bem_Estar;
import com.example.gicom_ipbeja.cursos.activity_Educacao_Basica;
import com.example.gicom_ipbeja.cursos.activity_Eletronica_Computadores;
import com.example.gicom_ipbeja.cursos.activity_Enfermagem;
import com.example.gicom_ipbeja.cursos.activity_Engenharia_Alimentar;
import com.example.gicom_ipbeja.cursos.activity_Engenharia_Ambiente;
import com.example.gicom_ipbeja.cursos.activity_Engenharia_Informatica;
import com.example.gicom_ipbeja.cursos.activity_Gestao_Empresas;
import com.example.gicom_ipbeja.cursos.activity_Gestao_Organizacoes_Sociais;
import com.example.gicom_ipbeja.cursos.activity_Gestao_de_Empresas_Pos;
import com.example.gicom_ipbeja.cursos.activity_Informacao_Comercializacao_Turistica;
import com.example.gicom_ipbeja.cursos.activity_Olivicultura_Azeite_Azeitona_Mesa;
import com.example.gicom_ipbeja.cursos.activity_Psicogerontologia;
import com.example.gicom_ipbeja.cursos.activity_Redes_Sistemas_Informaticos;
import com.example.gicom_ipbeja.cursos.activity_Sistemas_Protecao_Ambiente;
import com.example.gicom_ipbeja.cursos.activity_Solicitadoria;
import com.example.gicom_ipbeja.cursos.activity_Solicitadoria_Distancia;
import com.example.gicom_ipbeja.cursos.activity_Som_Imagem;
import com.example.gicom_ipbeja.cursos.activity_Tecnologia_Inovacao_Alimentar;
import com.example.gicom_ipbeja.cursos.activity_Tecnologias_Agroambientais_Sustentabilidade;
import com.example.gicom_ipbeja.cursos.activity_Tecnologias_Bionaliticas;
import com.example.gicom_ipbeja.cursos.activity_Tecnologias_Web_Dispositivos_Moveis;
import com.example.gicom_ipbeja.cursos.activity_Tecnologias_para_Gestao_Qualidade_Seguranca;
import com.example.gicom_ipbeja.cursos.activity_Terapia_Ocupacional;
import com.example.gicom_ipbeja.cursos.activity_Turismo;
import com.example.gicom_ipbeja.cursos.activity_Viticultura_Enologia;
import com.example.gicom_ipbeja.data.localdatabase.CourseService;
import com.example.gicom_ipbeja.data.localdatabase.CoursesItem;
import com.example.gicom_ipbeja.data.localdatabase.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PesquisaActivity extends AppCompatActivity {

    private List<CoursesItem> courseList = new ArrayList<>();
    private List<CoursesItem> filteredCourseList = new ArrayList<>();
    private AutoCompleteCourseAdapter autoCompleteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa);
        AutoCompleteTextView autoCompleteTextView = findViewById(R.id.actv);
        autoCompleteAdapter = new AutoCompleteCourseAdapter(this);
        autoCompleteTextView.setAdapter(autoCompleteAdapter);
        fetchRestaurantsFromAPI();

        WebView webView = findViewById(R.id.webView);
        String vidio = "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/470eT-USshM?si=cFzA8hxuknKXaG-i\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>";
        webView.loadData(vidio, "text/html", "utf-8");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        autoCompleteAdapter.setOnCourseItemClickListener(courseItem -> {
            openCourseClassification(courseItem);
        });

    }

    private void fetchRestaurantsFromAPI() {
        CourseService service = RetrofitClientInstance.getRetrofitInstance().create(CourseService.class);
        Call<List<CoursesItem>> call = service.getCourses();
        Call<List<CoursesItem>> call2 = service.deleteCourses();
        Call<List<CoursesItem>> call3 = service.addCourses();
        Call<List<CoursesItem>> call4 = service.updateCourses();

        call.enqueue(new Callback<List<CoursesItem>>() {
            @Override
            public void onResponse(Call<List<CoursesItem>> call, Response<List<CoursesItem>> response) {
                if (response.isSuccessful()) {
                    courseList = response.body();
                    Toast.makeText(PesquisaActivity.this, "Api ligada com sucesso", Toast.LENGTH_SHORT).show();
                    autoCompleteAdapter.updateList(courseList);
                } else {
                    Toast.makeText(PesquisaActivity.this, "Falha ao obter dados da API", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<CoursesItem>> call, Throwable t) {
                Toast.makeText(PesquisaActivity.this, "Erro de conexão: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void openCourseClassification(CoursesItem course) {
        Intent intent = course.getIntentForCourse(this);
        startActivity(intent);
    }

    public void Home(View view) {
        Intent intent = (new Intent(PesquisaActivity.this, MainActivity.class));
        startActivity(intent);
    }

    public void Message(View view) {
        Intent intent = (new Intent(PesquisaActivity.this, apoioActivity.class));
        startActivity(intent);
    }
    public void Share(View view) {
        Intent intent = (new Intent(PesquisaActivity.this, ActivityShare.class));
        startActivity(intent);
    }
}

