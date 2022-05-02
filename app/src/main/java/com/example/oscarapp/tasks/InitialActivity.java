package com.example.oscarapp.tasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.oscarapp.MenuActivity;
import com.example.oscarapp.R;

public class InitialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_initial);

        Intent menuTeste = new Intent(getApplicationContext(), MenuActivity.class);
        startActivity(menuTeste);
    }
}