package com.example.gicom_ipbeja.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.Message;

import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder> {
    private List<Message> messages;

    public MessageAdapter(List<Message> messages) {
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view;
        if (viewType == 0) {
            view = inflater.inflate(R.layout.item_message_sent, parent, false);
        } else {
            view = inflater.inflate(R.layout.item_message_received, parent, false);
        }
        return new MessageViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        Message message = messages.get(position);
        holder.bind(message);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messages.get(position);
        return message.isSentByUser() ? 0 : 1;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }

    public class MessageViewHolder extends RecyclerView.ViewHolder {
        private TextView contentTextView;

        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            contentTextView = itemView.findViewById(R.id.contentTextView);
        }

        public void bind(Message message) {
            contentTextView.setText(message.getContent());
        }

    }
}
