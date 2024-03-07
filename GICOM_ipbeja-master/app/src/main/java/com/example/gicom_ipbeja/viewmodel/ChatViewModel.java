package com.example.gicom_ipbeja.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.gicom_ipbeja.data.localdatabase.Message;
import com.example.gicom_ipbeja.model.ChatRepository;

import java.util.List;

public class ChatViewModel extends AndroidViewModel {

    private ChatRepository chatRepository;
    private LiveData<List<Message>> messageListLiveData;

    public ChatViewModel(@NonNull Application application) {
        super(application);
        chatRepository = new ChatRepository(application);
    }

    public LiveData<List<Message>> getMessages(int chatId) {
        messageListLiveData = chatRepository.getMessagesForChat(chatId);
        return messageListLiveData;
    }

    public void sendMessage(int chatId, String content) {
        chatRepository.sendMessage(chatId, content);
    }

    public void deleteMessage(Message message) {
        chatRepository.deleteMessage(message);
    }
}
