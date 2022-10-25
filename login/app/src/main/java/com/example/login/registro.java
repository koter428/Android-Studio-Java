package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class registro extends AppCompatActivity implements View.OnClickListener{
EditText ruser , rpas, rnom, rape ;
Button reg, canc;
daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ruser=(EditText) findViewById(R.id.ruser);
        rpas=(EditText) findViewById(R.id.rpass);
        rnom=(EditText) findViewById(R.id.rnombre);
        rape=(EditText) findViewById(R.id.rapellido);
        reg=(Button) findViewById(R.id.btnrregistrar);
        canc=(Button) findViewById(R.id.btnrCancelar);
        reg.setOnClickListener(this);
        canc.setOnClickListener(this);
        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnrregistrar:
                usuario u=new usuario();
                u.setUsuario(ruser.getText().toString());
                u.setPassword(rpas.getText().toString());
                u.setNombre(rnom.getText().toString());
                u.setApellido(rape.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this,"ERROR: Campos vacios",Toast.LENGTH_LONG).show();
                }else if (dao.insertUsuario(u)){
                    Toast.makeText(this,"Registro exitoso",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(registro.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"Usuario repetidoa",Toast.LENGTH_LONG).show();
                }

                break;
            case  R.id.btnrCancelar:
                Intent i=new Intent(registro.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}