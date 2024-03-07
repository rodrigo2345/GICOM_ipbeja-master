package com.example.gicom_ipbeja.model;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.gicom_ipbeja.data.localdatabase.AppDatabase;
import com.example.gicom_ipbeja.data.localdatabase.Chat;
import com.example.gicom_ipbeja.data.localdatabase.Message;

import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatRepository {
    private AppDatabase database;
    private LiveData<List<Chat>> chatListLiveData;
    private LiveData<List<Message>> messageListLiveData;

    public ChatRepository(Application application) {
        database = AppDatabase.getInstance(application);
        chatListLiveData = database.chatDao().getAllChats();
    }

    public LiveData<List<Chat>> getChats() {
        return chatListLiveData;
    }

    public LiveData<List<Message>> getMessagesForChat(int chatId) {
        messageListLiveData = database.messageDao().getMessagesByChatId(chatId);
        return messageListLiveData;
    }

    public LiveData<Message> getLastMessageForChat(int chatId) {
        return database.messageDao().getLastMessageByChatId(chatId);
    }

    public void addChat(String chatName) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            Chat chat = new Chat(chatName);
            database.chatDao().insert(chat);
        });
    }

    public void deleteChat(Chat chat) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            database.chatDao().delete(chat);
        });
    }

    public void sendMessage(int chatId, String content) {
        Date timestamp = new Date();
        Message message = new Message(chatId, content, true, timestamp);

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            database.messageDao().insert(message);
            handleResponse(chatId, content, timestamp);
        });
    }

    private void handleResponse(int chatId, String content, Date timestamp) {
        boolean shouldReply = false;
        String replyMessageContent = "";

        switch (content) {
            case "Ola":
                shouldReply = true;
                replyMessageContent = "Olá! Bem-vindo ao chat. Estou pronto para ajudar." +
                        " Diga-me das seguintes opções, qual a opção que eu possa responder de forma objetiva:\n" +
                        "1- Quantas escolas é formado o instituto politécnico de beja?;\n" +
                        "2- Data de criação da aplicação móvel?;\n" +
                        "3- Quantos cursos tem o instituto politécnico de beja?\n" +
                        "Prima o número que mais identificas";
                break;
            case "Tchau":
                shouldReply = true;
                replyMessageContent = "Obrigado por ter confiado na minha inteligência artificial." +
                        " Foi um gosto ter respondido às suas questões. Até breve!";
                break;
            case "1":
                shouldReply = true;
                replyMessageContent = "O instituto politécnico de beja é formato por 4 escolas( Escola Superior Agrária,Escola Superior de Educação,Escola Superior de Saúde e Escola Superior de Tecnologia e Gestão.";
                break;
            case "2":
                shouldReply = true;
                replyMessageContent = "A data de criação da aplicação móvel, denominada de IPBeCourses Pesquisa de cursos, é de 2024.";
                break;
            case "3":
                shouldReply = true;
                replyMessageContent = "O instituto politécnico é constituido por 36 cursos sendo eles subdivididos por 4 escolas" +
                        "Escola Superior Agrária(12)" +
                        "Escola Superior de Educação(8)" +
                        "Escola Superior de Saúde(3)" +
                        "Escola Superior de Tecnologia e Gestão(13)";
                break;
            default:
                replyMessageContent = "Não conheço esse comando...";
                shouldReply = true;
                break;
        }

        if (shouldReply) {
            Message replyMessage = new Message(chatId, replyMessageContent, false, timestamp);
            database.messageDao().insert(replyMessage);
        }
    }

    public void deleteMessage(Message message) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            database.messageDao().delete(message);
        });
    }
}

