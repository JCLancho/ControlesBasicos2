package com.example.controlesbasicos2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.TransitionDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.controlesbasicos2.R;

public class ejercicio2 extends AppCompatActivity {

    private EditText primerDigito, segundoDigito, resultado;
    private TextView correctas, incorrectas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);
        primerDigito = findViewById(R.id.primerDigito);
        primerDigito.setText(generarNumeroAleatorio());
        segundoDigito = findViewById(R.id.segundoDigito);
        segundoDigito.setText(generarNumeroAleatorio());
        resultado = findViewById(R.id.resultado);
        correctas = findViewById(R.id.correctas);
        incorrectas = findViewById(R.id.incorrectas);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234 && resultCode == RESULT_OK){
            if (data.getBooleanExtra("resultado",true)){
                int a = Integer.parseInt(correctas.getText().toString()) + 1;
                correctas.setText(a+"");
            }else{
                int a = Integer.parseInt(incorrectas.getText().toString()) + 1;
                incorrectas.setText(a+"");
            }
            reiniciar();
        }
    }


    public void comprobar(View v){
        if(resultado.getText().length() > 0) {
            Intent intent = new Intent(this, ejercicio2b.class);
            intent.putExtra("primerDigito", primerDigito.getText().toString());
            intent.putExtra("segundoDigito", segundoDigito.getText().toString());
            intent.putExtra("resultado", resultado.getText().toString());
            startActivityForResult(intent, 1234);
        }else{
            int colorFrom = Color.TRANSPARENT;
            int colorTo = Color.RED;
            int duration = 1000;
            ObjectAnimator.ofObject(resultado, "backgroundColor", new ArgbEvaluator(),colorFrom,colorTo).setDuration(duration).start();
            ObjectAnimator.ofObject(resultado, "backgroundColor", new ArgbEvaluator(),colorTo,colorFrom).setDuration(duration).start();

        }
    }

    private void reiniciar(){
        primerDigito.setText(generarNumeroAleatorio());
        segundoDigito.setText(generarNumeroAleatorio());
        resultado.setText("");
    }

    private String generarNumeroAleatorio(){
        return ((int) (Math.random()*101)) + "";
    }
}
