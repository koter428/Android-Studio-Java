package com.practica.proyectofinal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Opciones extends AppCompatActivity implements View.OnClickListener {
    Button btnEditar, btnEliminar, btnMostrar, btnSalir;
    TextView nombre;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opciones);
        nombre=(TextView)findViewById(R.id.nombreUsuario);
        btnEditar=(Button)findViewById(R.id.btnEditar);
        btnEliminar=(Button)findViewById(R.id.btnEliminar);
        btnMostrar=(Button)findViewById(R.id.btnMostrar);
        btnSalir=(Button)findViewById(R.id.btnSalir);
        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+" "+u.getApellidos());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEditar:
                Intent a= new Intent(Opciones.this,Editar.class);
                a.putExtra("id", id);
                startActivity(a);
                finish();
                break;
            case R.id.btnEliminar:
                AlertDialog.Builder b=new AlertDialog.Builder(this);
                b.setMessage("Estas Seguro de Eliminar tu cuenta?");
                b.setCancelable(false);
                b.setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(dao.deleteUsuario(id)){
                            Toast.makeText(Opciones.this, "Se elimino correctamente!!", Toast.LENGTH_SHORT).show();
                            Intent a= new Intent(Opciones.this,Main.class);
                            startActivity(a);
                            finish();
                        } else {
                            Toast.makeText( Opciones.this, "ERROR: No se elimino la cuenta", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                b.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                        }
                });
                b.show();
                break;
            case R.id.btnMostrar:
                Intent c= new Intent(Opciones.this,Mostrar.class);
                startActivity(c);
                finish();
                break;
            case R.id.btnSalir:
                Intent i2= new Intent(Opciones.this, Inicio.class);
                i2.putExtra("id",u.getId());
                startActivity(i2);
                finish();
                break;
        }
    }

    public static class Registrar extends AppCompatActivity implements View.OnClickListener {
        EditText us, pas, nom, ap;
        Button reg,can;
        daoUsuario dao;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.registrar);
            us=(EditText)findViewById(R.id.RegUser);
            pas=(EditText)findViewById(R.id.RegPass);
            nom=(EditText)findViewById(R.id.RegNombre);
            ap=(EditText)findViewById(R.id.RegApellido);
            reg=(Button)findViewById(R.id.btnRegRegistrar);
            can=(Button)findViewById(R.id.btnRegCancelar);
            reg.setOnClickListener(this);
            can.setOnClickListener(this);
            dao= new daoUsuario(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btnRegRegistrar:
                    Usuario u= new Usuario();
                    u.setUsuario(us.getText().toString());
                    u.setPassword(pas.getText().toString());
                    u.setNombre(nom.getText().toString());
                    u.setApellidos(ap.getText().toString());
                    if (!u.isNull()){
                        Toast.makeText(this, "Error: Campos Vacios", Toast.LENGTH_SHORT).show();
                    } else if (dao.insertUsuario(u)){
                        Toast.makeText(this, "Registro Exitoso!!", Toast.LENGTH_SHORT).show();
                        Intent i2= new Intent(Registrar.this, Main.class);
                        startActivity(i2);
                        finish();
                        break;
                    } else {
                        Toast.makeText(this, "Usuario ya Registrado", Toast.LENGTH_SHORT).show();
                    }
                    break;

                case R.id.btnRegCancelar:
                    Intent i= new Intent(Registrar.this, Main.class);
                    startActivity(i);
                    finish();
                    break;
            }
        }
    }
}