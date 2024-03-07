package com.example.gicom_ipbeja.data.localdatabase;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "message")
public class Message {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private int chatId;
    private String content;
    private boolean isSentByUser;

    private Date timestamp;




    public Message(int chatId, String content, boolean isSentByUser, Date timestamp) {
        this.chatId = chatId;
        this.content = content;
        this.isSentByUser = isSentByUser;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }



    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSentByUser() {
        return isSentByUser;
    }

    public void setSentByUser(boolean sentByUser) {
        isSentByUser = sentByUser;
    }


    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getContent() {
        return this.content;
    }
}

