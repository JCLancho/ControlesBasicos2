package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ejercicio1 extends AppCompatActivity {

    EditText inputNombre, inputApellidos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        inputNombre = findViewById(R.id.inputNombre);
        inputApellidos = findViewById(R.id.inputApellidos);
    }

    public void verificar(View v){
        Intent intent = new Intent(this, ejercicio1b.class);
        intent.putExtra("nombre", inputNombre.getText());
        intent.putExtra("apellidos", inputApellidos.getText());
        startActivity(intent);
    }

    public void volver(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
