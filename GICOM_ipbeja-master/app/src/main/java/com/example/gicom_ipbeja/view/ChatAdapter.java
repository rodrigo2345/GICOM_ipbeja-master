package com.example.gicom_ipbeja.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<ChatAdapter.ChatViewHolder> {
    private List<Chat> chats;
    private OnChatClickListener listener;

    public ChatAdapter(List<Chat> chats, OnChatClickListener listener) {
        this.chats = chats != null ? chats : new ArrayList<>();
        this.listener = listener;
    }


    @NonNull
    @Override
    public ChatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chat, parent, false);
        return new ChatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatViewHolder holder, int position) {
        Chat chat = chats.get(position);
        holder.bind(chat);
    }

    @Override
    public int getItemCount() {
        return chats.size();
    }

    public void setChats(List<Chat> chats) {
        this.chats = chats != null ? chats : new ArrayList<>();
        notifyDataSetChanged();
    }

    public class ChatViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private TextView nameTextView;

        private TextView lastMessageTextView;


        public ChatViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            lastMessageTextView = itemView.findViewById(R.id.lastMessageTextView);
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }



        public void bind(Chat chat) {
            nameTextView.setText(chat.getName());
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Chat chat = chats.get(position);
                listener.onChatClick(chat);
            }
        }

        @Override
        public boolean onLongClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Chat chat = chats.get(position);
                listener.onChatLongClick(chat);
                return true;
            }
            return false;
        }
    }


    public interface OnChatClickListener {
        void onChatClick(Chat chat);
        void onChatLongClick(Chat chat);
    }
}

