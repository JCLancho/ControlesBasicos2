package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class ejercicio3 extends AppCompatActivity {

    private EditText inputNombre, inputApellidos;
    private RadioButton radioMasculino, radioFemenino;
    private RadioButton[] radios = new RadioButton[2];
    private CheckBox checkMusica, checkLectura, checkDeportes, checkViajar;
    private CheckBox[] checks = new CheckBox[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio3);
        inputNombre = findViewById(R.id.inputNombre);
        inputApellidos = findViewById(R.id.inputApellidos);
        radios[0] = findViewById(R.id.radioMasculino);
        radios[1] = findViewById(R.id.radioFemenino);
        checks[0] = findViewById(R.id.checkMusica);
        checks[1] = findViewById(R.id.checkLectura);
        checks[2] = findViewById(R.id.checkDeportes);
        checks[3] = findViewById(R.id.checkViajar);
    }

    public void enviar(View v){
        if(validar()){
            Intent intent = new Intent(this, ejercicio3b.class);
            intent.putExtra("nombre", inputNombre.getText().toString());
            intent.putExtra("apellidos", inputApellidos.getText().toString());
            intent.putExtra("sexo",
                    (radios[0].isChecked() ?
                            radios[0].getText().toString() :
                            radios[1].getText().toString()));
            intent.putExtra("musica",
                    checks[0].isChecked()?checks[0].getText().toString():"");
            intent.putExtra("lectura",
                    checks[1].isChecked()?checks[1].getText().toString():"");
            intent.putExtra("deportes",
                    checks[2].isChecked()?checks[2].getText().toString():"");
            intent.putExtra("viajar",
                    checks[3].isChecked()?checks[3].getText().toString():"");
            startActivity(intent);
        }
    }

    private boolean validar(){
        boolean sexoSeleccionado = false;
        for(RadioButton rb : radios)
            if(rb.isChecked()) {
                sexoSeleccionado = true;
            }
        boolean aficionesSeleccionadas = false;
        for(CheckBox cb : checks)
            if(cb.isChecked())
                aficionesSeleccionadas = true;
        if(inputNombre.getText().toString().equals("")){
            Toast toast = Toast.makeText(getApplicationContext(),"Introduce tu nombre", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        if(inputApellidos.getText().toString().equals("")){
            Toast toast = Toast.makeText(getApplicationContext(),"Introduce tus apellidos", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        if(!sexoSeleccionado){
            Toast toast = Toast.makeText(getApplicationContext(),"Seleccion tu sexo", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        if(!aficionesSeleccionadas){
            Toast toast = Toast.makeText(getApplicationContext(),"Selecciona al menos una aficion", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }
        return true;
    }
}
