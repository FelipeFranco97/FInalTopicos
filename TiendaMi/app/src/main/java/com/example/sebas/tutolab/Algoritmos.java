package com.example.sebas.tutolab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sebas.tutolab.Objetos.FirebaseReferences;
import com.example.sebas.tutolab.Objetos.Tutores;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Algoritmos extends AppCompatActivity {
    Button Leche,Huevo,Cuajada;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algoritmos);

        Leche =findViewById(R.id.button7);
        Huevo =(Button) findViewById(R.id.button5);
        Cuajada =findViewById(R.id.button6);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tutorialRef = database.getReference(FirebaseReferences.REFERENCIA2);
        Leche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Leche","1.500","Surtitodo");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"Leche en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Algoritmos.this, Menu.class);
                startActivity(siguiente);
            }


        });
        Huevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Huevos","8.000","Surtitodo");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"Huevos en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Algoritmos.this, Menu.class);
                startActivity(siguiente);


            }
        });

        Cuajada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Cuajada","4.000","Surtitodo");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"Cuajada en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Algoritmos.this, Menu.class);
                startActivity(siguiente);

            }
        });
    }
}
