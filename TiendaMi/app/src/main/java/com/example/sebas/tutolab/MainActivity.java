package com.example.sebas.tutolab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btSignIn,btRegister;
    EditText etEmail,etPassword;

    FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btRegister = (Button) findViewById(R.id.btRegister);
        btSignIn = (Button)findViewById(R.id.btSignIn);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPassword);

        btRegister.setOnClickListener(this);
        btSignIn.setOnClickListener(this);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null)
                {
                    Log.i("SESION","sesion iniciada con email: "+user.getEmail());
                }else
                    {
                        Log.i("SESION","Sesion cerrada");
                    }
            }
        };


    }
    private void registrar (String email, String pass)
    {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Log.i("SESION","Usuario creado completamente");
                }else
                    {
                        Log.e("SESION",task.getException().getMessage()+"");
                    }
            }
        });


    }

    private void iniciarSesion (String email, String pass)
    {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful())
                {
                    Log.i("SESION","sesion iniciada");
                    Toast.makeText(getApplicationContext(),"sesion iniciada",Toast.LENGTH_SHORT).show();
                    Intent siguiente = new Intent(MainActivity.this, Menu.class);
                    startActivity(siguiente);

                }else
                {
                    Log.e("SESION",task.getException().getMessage()+"");
                    Toast.makeText(getApplicationContext(),"usuario incorrecto",Toast.LENGTH_SHORT).show();
                }
            }
        });;




    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btSignIn:
                String emailInicio = etEmail.getText().toString();
                String passInicio = etPassword.getText().toString();
                iniciarSesion(emailInicio,passInicio);
                break;
            case R.id.btRegister:
                String emailReg = etEmail.getText().toString();
                String passReg = etPassword.getText().toString();
                registrar(emailReg,passReg);
                break;

        }
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        FirebaseAuth.getInstance().addAuthStateListener(mAuthListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mAuthListener != null)
        {
           FirebaseAuth.getInstance().removeAuthStateListener(mAuthListener);
        }
    }
}
