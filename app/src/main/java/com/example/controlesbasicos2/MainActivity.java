package com.example.controlesbasicos2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ejercicio1(View v){
        Intent intent = new Intent(this, ejercicio1.class);
        startActivity(intent);
    }

    public void ejercicio2(View v){
        Intent intent = new Intent(this, ejercicio1.class);
        startActivity(intent);
    }

    public void ejercicio3(View v){
        Intent intent = new Intent(this, ejercicio1.class);
        startActivity(intent);
    }

    public void ejercicio4(View v){
        Intent intent = new Intent(this, ejercicio1.class);
        startActivity(intent);
    }

}
