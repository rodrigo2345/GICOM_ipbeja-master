package com.example.gicom_ipbeja.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gicom_ipbeja.R;
import com.example.gicom_ipbeja.data.localdatabase.Localizacao;

import java.util.List;

public class LocalizacaoAdapter extends RecyclerView.Adapter<LocalizacaoAdapter.LocalizacaoViewHolder> {


    private List<Localizacao> localizacaoList;

    public LocalizacaoAdapter(List<Localizacao> localizacaoList) {
        this.localizacaoList = localizacaoList;
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
    public LocalizacaoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.localizacao_activity, parent, false);
        return new LocalizacaoViewHolder(rootView);
    }


    /**
     * Permite associar a um ViewHolder dados de um item da lista
     *
     * @param holder   The ViewHolder which should be updated to represent the contents of the
     *                 item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(@NonNull LocalizacaoViewHolder holder, int position) {
        Localizacao localizacao = this.localizacaoList.get(position);
        holder.course_name.setText(localizacao.getCourse_name());
        Glide.with(holder.rootView.getContext()).load(localizacao.getAvatar2()).into(holder.avatar);
        holder.localizacao_text_view.setText(localizacao.getLocalizacao_text_view20());
        holder.telefone_text_view.setText(localizacao.getTelefone_text_view20());

        holder.web_site.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = localizacao.getWeb_site20();
                if (url != null && !url.isEmpty()) {
                    Context context = holder.itemView.getContext();
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    context.startActivity(intent);
                }
            }
        });
    }
    /**
     * Devolver o número de Items que a RecyclerView deve apresentar
     *
     * @return numero de items da recyclerView
     */
    @Override
    public int getItemCount() {
        return this.localizacaoList.size();
    }

    public class LocalizacaoViewHolder extends RecyclerView.ViewHolder {
        private View rootView;
        private TextView course_name;

        private ImageView avatar;

        private TextView localizacao_text_view;

        private TextView web_site;

        private TextView telefone_text_view;

        public LocalizacaoViewHolder(@NonNull View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.course_name = rootView.findViewById(R.id.restaurant_name2);
            this.avatar = rootView.findViewById(R.id.avatar2);
            this.localizacao_text_view = rootView.findViewById(R.id.localizacao_text_view20);
            this.web_site = rootView.findViewById(R.id.web_site20);
            this.telefone_text_view = rootView.findViewById(R.id.telefone_text_view20);

        }
    }
}
