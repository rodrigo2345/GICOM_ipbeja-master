package com.example.gicom_ipbeja.data.localdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ClienteDAO {
    @Query("SELECT * FROM clientes WHERE username = :username AND password = :password")
    Cliente getClienteByUsernameAndPassword(String username, String password);


    @Insert
    void inserirCliente(Cliente cliente);


    @Query("SELECT * FROM clientes WHERE username = :username")
    Cliente getByUsername(String username);


    @Query("SELECT COUNT(*) FROM clientes WHERE username = :username")
    int countUsernames(String username);

    @Query("SELECT COUNT(*) FROM clientes WHERE email = :email")
    int countEmails(String email);

    @Query("SELECT COUNT(*) FROM clientes WHERE password = :password")
    int countPasswords(String password);
    @Update
    void atualizarCliente(Cliente cliente);
}

