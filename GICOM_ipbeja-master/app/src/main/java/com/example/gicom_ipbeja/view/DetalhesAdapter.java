package com.example.gicom_ipbeja.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.Detalhes;

import java.util.List;

public class DetalhesAdapter extends RecyclerView.Adapter<DetalhesAdapter.DetalhesViewHolder> {


    private List<Detalhes> detalhesList;

    public DetalhesAdapter(List<Detalhes> detalhesList) {
        this.detalhesList = detalhesList;
    }

    /**
     * Criar um novo ViewHolder sempre que for necessário
     *
     * @param parent   The ViewGroup into which the new View will be added after it is bound to
     *                 an adapter position.
     * @param viewType The view type of the new View.
     * @return
     */
    @NonNull
    @Override
    public DetalhesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.courses_details, parent, false);
        return new DetalhesViewHolder(rootView);
    }


    /**
     * Permite associar a um ViewHolder dados de um item da lista
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull DetalhesViewHolder holder, int position) {
        Detalhes detalhes = this.detalhesList.get(position);
        holder.name_course.setText(detalhes.getName_course());
        Glide.with(holder.rootView.getContext()).load(detalhes.getAvatar()).into(holder.avatar);
        holder.tipo.setText(detalhes.getTipo());
        holder.inicio.setText(detalhes.getInicio());
        holder.objetivos.setText(detalhes.getObjetivos());
    }

    /**
     * Devolver o número de Items que a RecyclerView deve apresentar
     *
     * @return numero de items da recyclerView
     */
    @Override
    public int getItemCount() {
        return this.detalhesList.size();
    }

    public class DetalhesViewHolder extends RecyclerView.ViewHolder {
        private View rootView;

        private TextView name_course;
        private ImageView avatar;


        private TextView tipo;

        private TextView inicio;


        private TextView objetivos;

        public DetalhesViewHolder(@NonNull View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.name_course = rootView.findViewById(R.id.name_course);
            this.avatar = rootView.findViewById(R.id.avatar);
            this.tipo = rootView.findViewById(R.id.tipo);
            this.inicio = rootView.findViewById(R.id.inicio);
            this.objetivos = rootView.findViewById(R.id.objetivos);
        }
    }
}
