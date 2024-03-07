package com.example.gicom_ipbeja.data.localdatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "clientes")
public class Cliente {
    @PrimaryKey(autoGenerate = true)
    Integer cod_cliente;

    @ColumnInfo(name = "nome")
    String nome;

    @ColumnInfo(name = "username")
    String username;

    @ColumnInfo(name = "password")
    String password;

    @ColumnInfo(name = "email")
    String email;

    @ColumnInfo(name = "distrito")
    public String distrito;

    @ColumnInfo(name = "escola")
    public String escola;

    public Cliente(String nome, String username, String password, String email, String distrito,String escola) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.email = email;
        this.distrito = distrito;
        this.escola = escola;
    }

    public Integer getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(Integer cod_cliente) {
        this.cod_cliente = cod_cliente;
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }


    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.nome = escola;
    }


}

