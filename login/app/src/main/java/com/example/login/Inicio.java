package com.example.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
Button btneditar, btneliminar, btnmostrar, btnsalir;
TextView nombre;
int id=0;
usuario u;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        nombre=(TextView) findViewById(R.id.nombreusuario);
        btneditar=(Button) findViewById(R.id.btneditar);
        btneliminar = (Button) findViewById(R.id.btneliminar);
        btnmostrar= (Button) findViewById(R.id.btnmostrar );
        btnsalir= (Button) findViewById(R.id.btnrCancelar);

        btneditar.setOnClickListener( this);
        btneliminar.setOnClickListener(this);
        btnmostrar.setOnClickListener(this);
        btnsalir.setOnClickListener(this);

     Bundle b=getIntent().getExtras();
     id=b.getInt("id");
     dao=new daoUsuario(this);
     u=dao.getusuariobyid(id);
     nombre.setText(u.getNombre()+""+u.getApellido());
    }

    @Override
    public void onClick(View v) {
switch (v.getId()) {
    case R.id.btneditar:
        Intent a=new Intent(Inicio.this,editar.class);
        a.putExtra("id",id);
        startActivity(a);
        break;
    case R.id.btneliminar:
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setMessage("Estas seguro de eliminar");
        b.setCancelable(false);
        b.setPositiveButton("si", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(dao.deleteUsuario(id)){
                    Toast.makeText(Inicio.this,"Eliminado",Toast.LENGTH_LONG).show();
                    Intent i3=new Intent(Inicio.this,MainActivity.class);
                    startActivity(i3);
                    finish();

                }else  {
            }
            }
                });
        b.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                 dialogInterface.cancel();
            }
        });
        b.show();

        break;
    case R.id.btnmostrar:
        Intent a1=new Intent(Inicio.this,Mostrar.class);
        startActivity(a1);
        break;
    case R.id.btnrCancelar:
        Intent a3=new Intent(Inicio.this,MainActivity.class);
        startActivity(a3);
}
    }
}