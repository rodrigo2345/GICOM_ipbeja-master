package com.example.gicom_ipbeja.data.localdatabase;

public class Detalhes {



    private String name_course;
    private String  avatar;

    private String tipo;

    private String inicio;

    private String objetivos;


    public Detalhes(String name_course, String avatar, String tipo, String inicio, String objetivos) {

        this.name_course = name_course;
        this.avatar = avatar;
        this.tipo = tipo;
        this.inicio = inicio;
        this.objetivos = objetivos;
    }


    public String getName_course() {
        return name_course;
    }

    public void setName_course(String name_course) {
        this.name_course = name_course;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }



    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }


    public String getObjetivos() {
        return objetivos;
    }

    public void setObjetivos(String objetivos) {
        this.objetivos = objetivos;
    }

}