package com.example.gicom_ipbeja.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gicom_ipbeja.data.localdatabase.Chat;
import com.example.gicom_ipbeja.data.localdatabase.Message;
import com.example.gicom_ipbeja.model.ChatRepository;

import java.util.List;

public class ApoioViewModel extends AndroidViewModel {

    private ChatRepository chatRepository;
    private LiveData<List<Chat>> chatListLiveData;

    public ApoioViewModel(@NonNull Application application) {
        super(application);
        chatRepository = new ChatRepository(application);
        chatListLiveData = chatRepository.getChats();
    }

    public LiveData<List<Chat>> getChats() {
        return chatListLiveData;
    }

    public void addChat(String chatName) {
        chatRepository.addChat(chatName);
    }

    public void deleteChat(Chat chat) {
        chatRepository.deleteChat(chat);
    }

    public LiveData<Message> getLastMessageForChat(int chatId) {
        return chatRepository.getLastMessageForChat(chatId);
    }
}
