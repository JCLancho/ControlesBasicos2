package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ejercicio3b extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3b);
        textView = findViewById(R.id.textView);
        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellidos = extras.getString("apellidos");
        String sexo = extras.getString("sexo");
        String musica = extras.getString("musica");
        String lectura = extras.getString("lectura");
        String deportes = extras.getString("deportes");
        String viajar = extras.getString("viajar");
        StringBuffer mensaje = new StringBuffer();
        mensaje.append(nombre + " " + apellidos + "\n");
        mensaje.append("Sexo: " + sexo+"\n");
        mensaje.append("Aficiones:" + "\n");
        mensaje.append(musica.equals("")?"":"\t"+musica);
        mensaje.append(lectura.equals("")?"":"\t"+lectura);
        mensaje.append(deportes.equals("")?"":"\t"+deportes);
        mensaje.append(viajar.equals("")?"":"\t"+viajar);
        textView.setText(mensaje.toString());
    }
}
