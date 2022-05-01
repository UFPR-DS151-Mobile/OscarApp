package com.example.oscarapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscarapp.R;
import com.example.oscarapp.models.FilmeModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class DetalheItemActivity extends AppCompatActivity {
    int position;
    FilmeModel filme;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_item);

        position = getIntent().getIntExtra("position", position);
        filme = FilmesActivity.listTestes.get(position);
        TextView textViewFilm = findViewById(R.id.textViewNomeDetalhe);
        TextView textViewFilmType = findViewById(R.id.textViewGeneroDetalhe);
        ImageView imageViewFilm = findViewById(R.id.imageViewImagemDetalhe);

        textViewFilm.setText(filme.getNome());
        textViewFilmType.setText(filme.getGenero());
        Picasso.get().load(filme.getFoto())
                .fit()
                .noFade()
                .into(imageViewFilm, new Callback() {
                    @Override
                    public void onSuccess() {
                    }
                    @Override
                    public void onError(Exception e) {
                        e.printStackTrace();
                    }
                });

    }

    public void votarFilme(View view){
        Toast.makeText(this, "falta implementar o voto", Toast.LENGTH_SHORT).show();
    }

}
