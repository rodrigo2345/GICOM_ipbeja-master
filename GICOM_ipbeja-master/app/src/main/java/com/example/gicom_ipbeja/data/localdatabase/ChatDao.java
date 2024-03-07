package com.example.gicom_ipbeja.data.localdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ChatDao {
    @Insert
    void insert(Chat chat);

    @Update
    void update(Chat chat);

    @Delete
    void delete(Chat chat);



    @Query("SELECT * FROM chat ORDER BY (SELECT MAX(timestamp) FROM message WHERE message.chatId = chat.id) DESC")
    LiveData<List<Chat>> getAllChats();

}

