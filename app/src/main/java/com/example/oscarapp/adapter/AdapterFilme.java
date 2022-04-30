package com.example.oscarapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.oscarapp.R;
import com.example.oscarapp.models.Filme;

import java.util.List;

public class AdapterFilme extends RecyclerView.Adapter<AdapterFilme.MyViewHolder> {

private List<Filme> listFilmes;

public AdapterFilme(List<Filme> listFilme) {
        this.listFilmes = listFilmes;
        }

public class MyViewHolder extends RecyclerView.ViewHolder {
    TextView nome, genero, imagem;

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
        Filme filme = listFilmes.get(position);
        holder.nome.setText(filme.getNome());
        holder.genero.setText(filme.getGenero());
        holder.imagem.setText(filme.getImagem());
    }

    @Override
    public int getItemCount() {
        return listFilmes.size();
    }
}
