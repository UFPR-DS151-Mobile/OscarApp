package com.example.oscarapp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oscarapp.MainActivity;
import com.example.oscarapp.R;
import com.example.oscarapp.models.FilmeModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.List;

public class AdapterFilme extends RecyclerView.Adapter<AdapterFilme.MyViewHolder> {

    private List<FilmeModel> listFilmes;

    public AdapterFilme(List<FilmeModel> filmesList) {
        this.listFilmes = filmesList;
    }

public static class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nome, genero;
    ImageView imagem;

    public MyViewHolder(View view) {
        super(view);

        nome = view.findViewById(R.id.textViewNome);
        genero = view.findViewById(R.id.textViewGenero);
        imagem = view.findViewById(R.id.imageViewFilme);
    }
}

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_list_filmes, parent, false);
        return new MyViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        FilmeModel filme = listFilmes.get(position);
            if(filme.getFoto() != null && !filme.getFoto().isEmpty()){
                Picasso.get().load(filme.getFoto())
                        .fit()
                        .noFade()
                        .into(holder.imagem, new Callback() {
                            @Override
                            public void onSuccess() {
                                filme.setImagem(holder.imagem);
                            }

                            @Override
                            public void onError(Exception e) {
                                e.printStackTrace();
                                filme.setImagem(holder.imagem);
                            }
                        });
            } else {
                holder.imagem.setImageResource(R.drawable.filme);
            }

    }


    @Override
    public int getItemCount() {
        return listFilmes.size();
    }
}
