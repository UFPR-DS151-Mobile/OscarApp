package com.example.oscarapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.oscarapp.R;

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


    }
}