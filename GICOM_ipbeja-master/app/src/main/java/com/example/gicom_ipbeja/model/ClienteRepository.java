package com.example.gicom_ipbeja.model;

import android.app.Application;

import com.example.gicom_ipbeja.data.localdatabase.AppDatabase;
import com.example.gicom_ipbeja.data.localdatabase.Cliente;
import com.example.gicom_ipbeja.data.localdatabase.ClienteDAO;

public class ClienteRepository {
    private ClienteDAO clienteDAO;


    public ClienteRepository(Application application) {
        clienteDAO = AppDatabase.getInstance(application).clienteDAO();
    }

    public Cliente getClienteByUsernameAndPassword(String username, String password) {
        return clienteDAO.getClienteByUsernameAndPassword(username, password);
    }



    public void inserirCliente(Cliente cliente) {
        clienteDAO.inserirCliente(cliente);
    }

    public boolean checkIfUsernameExists(String username) {
        int count = clienteDAO.countUsernames(username);
        return count > 0;
    }

    public boolean checkIfEmailExists(String email) {
        int count = clienteDAO.countEmails(email);
        return count > 0;
    }

    public boolean checkIfPasswordExists(String password) {
        int count = clienteDAO.countPasswords(password);
        return count > 0;
    }
}
