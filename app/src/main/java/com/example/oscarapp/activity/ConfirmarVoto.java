package com.example.oscarapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oscarapp.R;
import com.example.oscarapp.Voto;
import com.example.oscarapp.models.DiretorModel;
import com.example.oscarapp.models.FilmeModel;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class ConfirmarVoto extends AppCompatActivity {

    TextView textViewFilmeNome, textViewDiretorNome, textViewTitulo;
    ImageView imageViewConfirma;
    Button buttonConfirma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_voto);

        imageViewConfirma = findViewById(R.id.imageViewConfirma);
        textViewTitulo = findViewById(R.id.textViewTitulo);
        textViewDiretorNome = findViewById(R.id.textViewDiretorNome);
        textViewFilmeNome = findViewById(R.id.textViewFilmeNome);
        buttonConfirma = findViewById(R.id.buttonConfirmar);

        final Voto voto = (Voto) getApplicationContext();

        try {
            FilmeModel filme = voto.getFilme();
            textViewFilmeNome.setText(filme.getNome());
            textViewFilmeNome.setVisibility(View.VISIBLE);

            Picasso.get().load(filme.getFoto())
                    .fit()
                    .noFade()
                    .into(imageViewConfirma, new Callback() {
                        @Override
                        public void onSuccess() {
                        }
                        @Override
                        public void onError(Exception e) {
                            e.printStackTrace();
                        }
                    });
        } catch(Exception e) {

        }
        try {
            DiretorModel diretor = voto.getDiretor();
            textViewDiretorNome.setText(diretor.getNome());
            textViewDiretorNome.setVisibility(View.VISIBLE);
        } catch(Exception e) {

        }

    }
}