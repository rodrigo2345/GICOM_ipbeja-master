package com.example.gicom_ipbeja.data.localdatabase;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MessageDao {
    @Insert
    void insert(Message message);

    @Update
    void update(Message message);

    @Delete
    void delete(Message message);

    @Query("SELECT * FROM message WHERE chatId = :chatId ORDER BY timestamp ASC")
    LiveData<List<Message>> getMessagesByChatId(int chatId);

    @Query("SELECT * FROM message WHERE chatId = :chatId AND id = (SELECT MAX(id) FROM message WHERE chatId = :chatId  )")
    LiveData<Message> getLastMessageByChatId(int chatId);

}
