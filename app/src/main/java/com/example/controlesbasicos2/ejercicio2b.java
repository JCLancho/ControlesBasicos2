package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ejercicio2b extends AppCompatActivity {

    private boolean operacion;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2b);
        resultado = findViewById(R.id.resultado);
        Bundle extras = getIntent().getExtras();
        String primerDigito = extras.getString("primerDigito");
        String segundoDigito = extras.getString("segundoDigito");
        String resultado = extras.getString("resultado");
        operacion = comprobarResultado(primerDigito,segundoDigito,resultado);
        resultado();
    }

    public void volver(View v){
        Intent intent = new Intent();
        intent.putExtra("resultado", operacion);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void resultado(){
        if(operacion){
            resultado.setText("CORRECTA");
        }else{
            resultado.setText("INCORRECTA");
        }
    }

    private boolean comprobarResultado(String primerDigito, String segundoDigito, String resultado){
        int a = Integer.parseInt(primerDigito);
        int b = Integer.parseInt(segundoDigito);
        int c = Integer.parseInt(resultado);
        return (a + b == c);
    }
}
