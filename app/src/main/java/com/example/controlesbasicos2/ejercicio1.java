package com.example.controlesbasicos2;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class ejercicio1 extends AppCompatActivity {

    EditText inputNombre, inputApellidos;
    TextView aceptado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);
        inputNombre = findViewById(R.id.inputNombre);
        inputApellidos = findViewById(R.id.inputApellidos);
        aceptado = findViewById(R.id.aceptado);
    }

    public void verificar(View v){
        Intent intent = new Intent(this, ejercicio1b.class);
        intent.putExtra("nombre", inputNombre.getText().toString());
        intent.putExtra("apellidos", inputApellidos.getText().toString());
        startActivityForResult(intent,1234);
    }

    public void volver(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234 && resultCode == RESULT_OK){
            if(data.getBooleanExtra("resultado", true)){
                aceptado.setText(R.string.aceptado);
            }else{
                aceptado.setText(R.string.rechazado);
            }
        }

    }

}
