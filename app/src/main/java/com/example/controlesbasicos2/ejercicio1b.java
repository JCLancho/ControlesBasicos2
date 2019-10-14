package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ejercicio1b extends AppCompatActivity {

    TextView saludo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1b);
        saludo = findViewById(R.id.saludo);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellidos = extras.getString("apellidos");
        saludo.setText("Hola " + nombre + " " + apellidos + " ¿Aceptas las condiciones?");

    }




}
