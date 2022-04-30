package com.example.oscarapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.example.oscarapp.R;
import com.example.oscarapp.adapter.AdapterFilme;
import com.example.oscarapp.models.Filme;
import com.example.oscarapp.models.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

public class FilmesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFilme;
    private List<Filme> listTestes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes);

        recyclerViewFilme = findViewById(R.id.recycleViewFilme);

        this.createFilme();
        AdapterFilme adapterTeste = new AdapterFilme(listTestes);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());

        recyclerViewFilme.setLayoutManager(layoutManager);
        recyclerViewFilme.setHasFixedSize(true);
        recyclerViewFilme.addItemDecoration(
                new DividerItemDecoration(this, LinearLayout.VERTICAL)
        );
        recyclerViewFilme.setAdapter(adapterTeste);

        recyclerViewFilme.addOnItemTouchListener(
                new RecyclerItemClickListener(
                        getApplicationContext(),
                        recyclerViewFilme,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override
                            public void onItemClick(View view, int position) {

                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                // não é necessário usar
                            }
                        }
                )
        );
    }

    public void createFilme() {
        // No caso aqui será populado usando os dados do banco (repetir essas duas linhas de código para cada row do banco)
        String nome = "filme1";
        String genero = "Genero1";
        String imagem = "Imagem1";

        Filme obj = new Filme(nome, genero, imagem);
        listTestes.add(obj);
    }
}