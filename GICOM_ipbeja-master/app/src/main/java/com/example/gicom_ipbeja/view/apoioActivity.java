package com.example.gicom_ipbeja.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.cursos.activity_Agronomia;
import com.example.gicom_ipbeja.data.localdatabase.Chat;
import com.example.gicom_ipbeja.viewmodel.ApoioViewModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class apoioActivity extends AppCompatActivity implements ChatAdapter.OnChatClickListener {

    private ApoioViewModel apoioViewModel;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoio);

        RecyclerView recyclerView = findViewById(R.id.recyclerView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        chatAdapter = new ChatAdapter(new ArrayList<>(), this);
        recyclerView.setAdapter(chatAdapter);

        apoioViewModel = new ViewModelProvider(this).get(ApoioViewModel.class);

        FloatingActionButton addChatButton = findViewById(R.id.addChatButton);
        addChatButton.setOnClickListener(v -> showAddChatDialog());

        loadChats();
    }

    private void loadChats() {
        apoioViewModel.getChats().observe(this, chatList -> {
            chatAdapter.setChats(chatList);

            for (Chat chat : chatList) {
                int chatId = chat.getId();
                apoioViewModel.getLastMessageForChat(chatId).observe(this, message -> {
                    if (message != null) {
                        TextView lastMessageTextView = findViewById(R.id.lastMessageTextView);
                        lastMessageTextView.setText("Última mensagem: " + message.getContent());
                    }
                });
            }
        });
    }

    private void showAddChatDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Nova Sala de Chat");

        final EditText inputEditText = new EditText(this);
        inputEditText.setInputType(InputType.TYPE_CLASS_TEXT);
        builder.setView(inputEditText);

        builder.setPositiveButton("Adicionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String chatName = inputEditText.getText().toString().trim();
                if (!chatName.isEmpty()) {
                    apoioViewModel.addChat(chatName);
                }
            }
        });

        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }


    @Override
    public void onChatClick(Chat chat) {
        Intent intent = new Intent(this, ChatActivity.class);
        intent.putExtra("chatId", chat.getId());
        startActivity(intent);
    }


    @Override
    public void onChatLongClick(final Chat chat) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Eliminar Sala de Chat");
        builder.setMessage("Tem a certeza que deseja eliminar esta sala de chat?");

        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                apoioViewModel.deleteChat(chat);
            }
        });

        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }



    public void Search(View view) {
        Intent intent = (new Intent(apoioActivity.this, PesquisaActivity.class));
        startActivity(intent);

    }
    public void Home(View view) {
        Intent intent = (new Intent(apoioActivity.this, MainActivity.class));
        startActivity(intent);
    }
    public void Share(View view) {
        Intent intent = (new Intent(apoioActivity.this, ActivityShare.class));
        startActivity(intent);
    }
}
