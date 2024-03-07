package com.example.gicom_ipbeja.data.localdatabase;

public class Localizacao {

    private String course_name;

    private String avatar;


    private String  localizacao_text_view;

    private String   web_site;

    private String telefone_text_view;


    public Localizacao(String course_name, String avatar, String localizacao_text_view, String web_site, String telefone_text_view)  {
        this.course_name = course_name;
        this.avatar = avatar;
        this.localizacao_text_view = localizacao_text_view;
        this.web_site = web_site;
        this.telefone_text_view = telefone_text_view;
    }





    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getAvatar2() {
        return avatar;
    }

    public void setAvatar2(String avatar2) {
        this.avatar = avatar2;
    }



    public String getLocalizacao_text_view20() {
        return localizacao_text_view;
    }

    public void setLocalizacao_text_view20(String localizacao_text_view20) {
        this.localizacao_text_view = localizacao_text_view20;
    }

    public String getWeb_site20() {
        return web_site;
    }

    public void setWeb_site20(String web_site20) {
        this.web_site = web_site20;
    }

    public String getTelefone_text_view20() {
        return telefone_text_view;
    }

    public void setTelefone_text_view20(String telefone_text_view20) {
        this.telefone_text_view = telefone_text_view20;
    }
}
