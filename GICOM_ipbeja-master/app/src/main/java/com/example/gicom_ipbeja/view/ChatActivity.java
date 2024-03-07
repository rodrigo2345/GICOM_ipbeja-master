package com.example.gicom_ipbeja.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.Message;
import com.example.gicom_ipbeja.viewmodel.ChatViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {

    private ChatViewModel chatViewModel;
    private List<Message> messageList;
    private MessageAdapter messageAdapter;
    private int chatId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        chatViewModel = new ViewModelProvider(this).get(ChatViewModel.class);

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        messageAdapter = new MessageAdapter(messageList);
        recyclerView.setAdapter(messageAdapter);

        FloatingActionButton sendMessageButton = findViewById(R.id.sendMessageButton);
        sendMessageButton.setOnClickListener(v -> sendMessage());

        chatId = getIntent().getIntExtra("chatId", 0);
        loadMessages(chatId);
    }

    public void showHelpDialog(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Perguntas?");


        String[] perguntas ={
                "Começe por dizer Ola para iniciar para terminar diga Tchau",
                "1- Quantas escolas é formado o instituto politécnico de beja?",
                "2- Data de criação da aplicação móvel?",
                "3- Quantos cursos tem o instituto politécnico de beja?"

        };

        builder.setItems(perguntas, null);

        builder.setPositiveButton("Fechar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void loadMessages(int chatId) {
        chatViewModel.getMessages(chatId).observe(this, messages -> {
            messageList = messages;
            messageAdapter.setMessages(messageList);
            scrollToBottom();
        });
    }

    private void sendMessage() {
        EditText messageEditText = findViewById(R.id.messageEditText);
        String content = messageEditText.getText().toString().trim();

        if (!content.isEmpty()) {
            chatViewModel.sendMessage(chatId, content);
            messageEditText.setText("");
            scrollToBottom();
        }
    }

    private void scrollToBottom() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.scrollToPosition(messageAdapter.getItemCount() - 1);
    }
}

