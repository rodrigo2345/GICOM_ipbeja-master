package com.example.gicom_ipbeja.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gicom_ipbeja.data.localdatabase.Cliente;
import com.example.gicom_ipbeja.model.ClienteRepository;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<Cliente> clienteLiveData = new MutableLiveData<>();
    private ClienteRepository clienteRepository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        clienteRepository = new ClienteRepository(application);
    }

    public void login(String username, String password) {
        Cliente cliente = clienteRepository.getClienteByUsernameAndPassword(username, password);
        clienteLiveData.setValue(cliente);
    }

    public LiveData<Cliente> getClienteLiveData() {
        return clienteLiveData;
    }
}
