package com.example.controlesbasicos2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    public void aceptar(View v){
        Intent intent = new Intent();
        intent.putExtra("resultado",true);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void rechazar(View v){
        Intent intent = new Intent();
        intent.putExtra("resultado",false);
        setResult(RESULT_OK, intent);
        finish();
    }


}
