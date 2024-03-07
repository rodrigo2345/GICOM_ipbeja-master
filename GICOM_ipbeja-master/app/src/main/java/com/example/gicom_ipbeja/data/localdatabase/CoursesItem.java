package com.example.gicom_ipbeja.data.localdatabase;

import android.content.Context;
import android.content.Intent;

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

public class CoursesItem {

    private int id;
    private String courseName;
    private String flagImage;

    public CoursesItem(int id, String courseName, String flagImage) {
        this.id = id;
        this.courseName = courseName;
        this.flagImage = flagImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCoursesName(String courseName) {
        this.courseName = courseName;
    }

    public void setFlagImage(String flagImage) {
        this.flagImage = flagImage;
    }

    public String getFlagImage() {
        return flagImage;
    }

    @Override
    public String toString() {
        return "RestaurantItem{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", flagImage='" + flagImage + '\'' +
                '}';
    }

    public Intent getIntentForCourse(Context context) {
        Intent intent = new Intent();

        switch (courseName) {
            case "Agronomia":
                intent = new Intent(context, activity_Agronomia.class);
                break;
            case "Ciencia e Tecnologia dos Alimentos":
                intent = new Intent(context, activity_Ciência_Tecnologias_dos_Alimentos.class);
                break;
            case "Engenharia Alimentar":
                intent = new Intent(context, activity_Engenharia_Alimentar.class);
                break;
            case "Engenharia do Ambiente":
                intent = new Intent(context, activity_Engenharia_Ambiente.class);
                break;
            case "Tecnologias Bionaliticas":
                intent = new Intent(context, activity_Tecnologias_Bionaliticas.class);
                break;
            case "Agropecuaria Mediterranica":
                intent = new Intent(context, activity_Agropecuaria_Mediterranica.class);
                break;
            case "Analises Laboratoriais":
                intent = new Intent(context, activity_Analises_Laboratoriais.class);
                break;
            case "Culturas Regadas":
                intent = new Intent(context, activity_Culturas_Regadas.class);
                break;
            case "Tecnologias Agroambientais e Sustentabilidade":
                intent = new Intent(context, activity_Tecnologias_Agroambientais_Sustentabilidade.class);
                break;
            case "Olivicultura, Azeite e Azeitona de Mesa":
                intent = new Intent(context, activity_Olivicultura_Azeite_Azeitona_Mesa.class);
                break;
            case "Sistemas de Protecao do Ambiente":
                intent = new Intent(context, activity_Sistemas_Protecao_Ambiente.class);
                break;
            case "Tecnologia e Inovacao Alimentar":
                intent = new Intent(context, activity_Tecnologia_Inovacao_Alimentar.class);
                break;
            case "Viticultura e Enologia":
                intent = new Intent(context, activity_Viticultura_Enologia.class);
                break;
            case "Audiovisual e Multimedia":
                intent = new Intent(context, activity_Audiovisual_Multimedia.class);
                break;
            case "Desporto":
                intent = new Intent(context, activity_Desporto.class);
                break;
            case "Educacao Basica":
                intent = new Intent(context, activity_Educacao_Basica.class);
                break;
            case "Apoio a Infancia":
                intent = new Intent(context, activity_Apoio_Infancia.class);
                break;
            case "Desporto, Lazer e Bem-Estar":
                intent = new Intent(context, activity_Desporto_Lazer_Bem_Estar.class);
                break;
            case "Psicogerontologia":
                intent = new Intent(context, activity_Psicogerontologia.class);
                break;
            case "Som e Imagem":
                intent = new Intent(context, activity_Som_Imagem.class);
                break;
            case "Enfermagem":
                intent = new Intent(context, activity_Enfermagem.class);
                break;
            case "Terapia Ocupacional":
                intent = new Intent(context, activity_Terapia_Ocupacional.class);
                break;
            case "Apoio em Cuidados Continuados Integrados":
                intent = new Intent(context, activity_Apoio_Cuidados_Continuados_Integrados.class);
                break;
            case "Engenharia Informatica":
                intent = new Intent(context, activity_Engenharia_Informatica.class);
                break;
            case "Gestao de Empresas":
                intent = new Intent(context, activity_Gestao_Empresas.class);
                break;
            case "Gestao de Empresas (Pos-Laboral)":
                intent = new Intent(context, activity_Gestao_de_Empresas_Pos.class);
                break;
            case "Solicitadoria":
                intent = new Intent(context, activity_Solicitadoria.class);
                break;
            case "Solicitadoria (Ensino a Distancia)":
                intent = new Intent(context, activity_Solicitadoria_Distancia.class);
                break;
            case "Turismo":
                intent = new Intent(context, activity_Turismo.class);
                break;
            case "Comercio Internacional":
                intent = new Intent(context, activity_Comercio_Internacional.class);
                break;
            case "Eletronica e Computadores":
                intent = new Intent(context, activity_Eletronica_Computadores.class);
                break;
            case "Gestao de Organizacoes Sociais":
                intent = new Intent(context, activity_Gestao_Organizacoes_Sociais.class);
                break;
            case "Informacao e Comercializacao Turistica":
                intent = new Intent(context, activity_Informacao_Comercializacao_Turistica.class);
                break;
            case "Redes e Sistemas Informaticos":
                intent = new Intent(context, activity_Redes_Sistemas_Informaticos.class);
                break;
            case "Tecnologias para a Gestao da Qualidade e Seguranca":
                intent = new Intent(context, activity_Tecnologias_para_Gestao_Qualidade_Seguranca.class);
                break;
            case "Tecnologias Web e Dispositivos Moveis":
                intent = new Intent(context, activity_Tecnologias_Web_Dispositivos_Moveis.class);
                break;
            default:
                break;
        }

        return intent;
    }
}