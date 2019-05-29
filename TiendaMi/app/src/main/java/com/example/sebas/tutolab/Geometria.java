package com.example.sebas.tutolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.sebas.tutolab.Objetos.FirebaseReferences;
import com.example.sebas.tutolab.Objetos.Tutores;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Geometria extends AppCompatActivity {
    Button Salsa,Aceite,Arroz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geometria);

        Salsa =findViewById(R.id.button14);
        Aceite =(Button) findViewById(R.id.button15);
        Arroz =findViewById(R.id.button16);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference tutorialRef = database.getReference(FirebaseReferences.REFERENCIA2);
        Salsa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Salsa","5.000","Marinilla");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"salsa en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Geometria.this, Menu.class);
                startActivity(siguiente);

            }


        });
        Aceite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Aceite","2.500","Marinilla");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"Aceite en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Geometria.this, Menu.class);
                startActivity(siguiente);

            }
        });

        Arroz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tutores tutor = new Tutores("Arroz","3.000","Marinilla");
                tutorialRef.push().setValue(tutor);
                Toast.makeText(getApplicationContext(),"Arroz en la lista",Toast.LENGTH_LONG).show();
                Intent siguiente = new Intent(Geometria.this, Menu.class);
                startActivity(siguiente);


            }
        });
    }
}
