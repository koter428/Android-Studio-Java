package com.practica.proyectofinal;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    TextView nombre;
    int id=0;
    Usuario u;
    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio);
        nombre=(TextView)findViewById(R.id.nombreUsuario);

        Bundle b=getIntent().getExtras();
        id=b.getInt("id");
        dao=new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText("Bienvenido/a "+u.getNombre()+" "+u.getApellidos());
    }

    @Override
    public void onClick(View v) {
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.usuario) {
            Intent i2= new Intent(Inicio.this, Opciones.class);
            i2.putExtra("id",u.getId());
            startActivity(i2);
            finish();
        }
        if (id==R.id.articulo) {
            Intent i2= new Intent(Inicio.this,Articulo.class);
            startActivity(i2);
            finish();
        }
        if (id==R.id.salir) {
            Intent i2= new Intent(Inicio.this,Main.class);
            startActivity(i2);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}