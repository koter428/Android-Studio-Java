package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText usu, pass;
    Button btnentrar, btnregistrar;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usu=(EditText) findViewById(R.id.ruser);
        pass=(EditText) findViewById(R.id.rpass);
        btnentrar=(Button) findViewById(R.id.btnentrar);
        btnregistrar=(Button) findViewById(R.id.btnregistrar);

        btnentrar.setOnClickListener((View.OnClickListener) this);
        btnregistrar.setOnClickListener((View.OnClickListener) this);
        dao=new daoUsuario(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnentrar:
                String u=usu.getText().toString();
                String p=pass.getText().toString();
                if (u.equals("")&&p.equals("")){
                    Toast.makeText(this,"Error campos vacios",Toast.LENGTH_LONG).show();
                }else if (dao.login(u,p)==1){
                    usuario ux=dao.getUsuario(u,p);
                    Toast.makeText(this,"Datos correctos",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(MainActivity.this,Inicio.class);
                    i2.putExtra("id", ux.getId());
                    startActivity(i2);
                    finish();
                } else{
                    Toast.makeText(this,"usuario y/o password incorrecto",Toast.LENGTH_LONG).show();

                }
                break;
            case  R.id.btnregistrar:
                Intent i=new Intent(MainActivity.this,registro.class);
                startActivity(i);
                break;

        }

    }
}