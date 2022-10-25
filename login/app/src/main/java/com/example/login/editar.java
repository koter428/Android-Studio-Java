package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editar extends AppCompatActivity implements View.OnClickListener{
    EditText editUser, edipass, edinombre,ediapellido;
    Button btnActualizar, btnCancelar;
    int id=0;
    usuario u;
    daoUsuario dao;
    Intent x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);
        editUser=(EditText) findViewById(R.id.ruser);
        edipass=(EditText) findViewById(R.id.rpass);
        edinombre=(EditText) findViewById(R.id.rnombre);
        ediapellido=(EditText) findViewById(R.id.rapellido);
        btnActualizar=(Button) findViewById(R.id.btnrregistrar);
        btnCancelar=(Button) findViewById(R.id.btnrCancelar);
        btnActualizar.setOnClickListener(this);
        btnCancelar.setOnClickListener(this);
        dao=new daoUsuario(this);

        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getusuariobyid(id);
        editUser.setText(u.getUsuario());
        edipass.setText(u.getPassword());
        edinombre.setText(u.getNombre());
        ediapellido.setText(u.getApellido());


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnrregistrar:
                usuario u=new usuario();
                u.setUsuario(editUser.getText().toString());
                u.setPassword(edipass.getText().toString());
                u.setNombre(edinombre.getText().toString());
                u.setApellido(ediapellido.getText().toString());
                if (!u.isNull()){
                    Toast.makeText(this,"ERROR: Campos vacios",Toast.LENGTH_LONG).show();
                }else if (dao.updateUsuario(u)){
                    Toast.makeText(this,"Actualizacion exitosa",Toast.LENGTH_LONG).show();
                    Intent i2=new Intent(editar.this,Mostrar.class);
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"No se puede actualizar",Toast.LENGTH_LONG).show();
                }
                Intent a=new Intent(editar.this,Mostrar.class);
                startActivity(a);
                break;
            case R.id.btnrCancelar:
                Intent i2=new Intent(editar.this,Inicio.class);
                startActivity(i2);
                break;
    }

    }
}