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
import com.example.oscarapp.conexao.RetrofitConfig;
import com.example.oscarapp.models.FilmeModel;
import com.example.oscarapp.models.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FilmesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewFilme;
    private List<FilmeModel> listTestes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filmes);

        recyclerViewFilme = findViewById(R.id.recycleViewFilme);

        this.createFilme();
        AdapterFilme adapterTeste = new AdapterFilme(listTestes, this);

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

        Retrofit r = new Retrofit.Builder()
                .baseUrl("http://wecodecorp.com.br/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        RetrofitConfig interfaceAPI = r.create(RetrofitConfig.class);

        Call<List<FilmeModel>> call = interfaceAPI.getFilme();

        call.enqueue(new Callback<List<FilmeModel>>() {
            @Override
            public void onResponse(Call<List<FilmeModel>> call, Response<List<FilmeModel>> response) {

                List<FilmeModel> filmes = response.body();

                listTestes.addAll(filmes);

                AdapterFilme adapterFilme = new AdapterFilme(listTestes, recyclerViewFilme.getContext());
                recyclerViewFilme.setLayoutManager(new LinearLayoutManager(recyclerViewFilme.getContext()));
                recyclerViewFilme.setAdapter(adapterFilme);
            }

            @Override
            public void onFailure(Call<List<FilmeModel>> call, Throwable t) {

            }
        });

        for (int i = 0; i<listTestes.size(); i++){
            System.out.println(listTestes.get(i));
        }

    }
}