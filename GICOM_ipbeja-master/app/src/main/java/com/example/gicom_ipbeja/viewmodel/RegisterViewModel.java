package com.example.gicom_ipbeja.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gicom_ipbeja.data.localdatabase.Cliente;
import com.example.gicom_ipbeja.model.ClienteRepository;

public class RegisterViewModel extends AndroidViewModel {
    private MutableLiveData<String> registrationMessage = new MutableLiveData<>();
    private ClienteRepository clienteRepository;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        clienteRepository = new ClienteRepository(application);
    }

    public void registerCliente(String nome, String username, String password, String email, String distrito, String escola) {
        if (!isValidEmail(email)) {
            registrationMessage.setValue("Por favor, insira um email válido.");
            return;
        }

        if (clienteRepository.checkIfEmailExists(email)) {
            registrationMessage.setValue("Este endereço de email já está registrado.");
            return;
        }

        if (clienteRepository.checkIfUsernameExists(username)) {
            registrationMessage.setValue("Nome de usuário já está em uso.");
            return;
        }


        if (clienteRepository.checkIfPasswordExists(password)) {
            registrationMessage.setValue("Esta senha já está em uso.");
            return;
        }

        Cliente cliente = new Cliente(nome, username, password, email, distrito, escola);
        clienteRepository.inserirCliente(cliente);
        registrationMessage.setValue("Cliente registrado com sucesso!");
    }

    public LiveData<String> getRegistrationMessage() {
        return registrationMessage;
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        return email.matches(emailPattern);
    }
}
