package com.programacionandroid.proyectotarea4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menuopciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.telefono) {
            Toast.makeText(this, "Se presionó el ícono del teléfono", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.camara) {
            Toast.makeText(this, "Se presionó el ícono de la cámara", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.correo) {
            Toast.makeText(this, "Se presionó el ícono del correo", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.opcion1) {
            Toast.makeText(this, "Se presionó la opción 1 del menú", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.opcion2) {
            Toast.makeText(this, "Se presionó la opción 2 del menú", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.opcion3) {
            Toast.makeText(this, "Se presionó la opción 3 del menú", Toast.LENGTH_LONG).show();
            return true;
        }
        if (id == R.id.opcion4) {
            Toast.makeText(this, "Se presionó la opción 4 del menú", Toast.LENGTH_LONG).show();
            return true;
            }  return super.onOptionsItemSelected(item);
        }
    }